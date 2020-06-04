package javaprinterserver.conexoes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaprinterserver.impressao.GerenciadorImpressao;
import javaprinterserver.tos.MessageTO;

/**
 *
 * @author gabriell
 */
public class ClientManager implements Runnable {

    private Socket clientSocket;

    private MaquinaEstadoRecepcao maquinaRecepcao = new MaquinaEstadoRecepcao();

    @Override
    public void run() {
        try {
            maquinaRecepcao.inicializa();
            System.out.println(clientSocket.hashCode() + ": Conexão cliente estabelecida");
            InputStream stream = clientSocket.getInputStream();
            try {
                int bytesLidos = 0;
                do {
                    byte[] dados = new byte[1024];
                    bytesLidos = stream.read(dados);
                    if (bytesLidos > 0) {
                        List<MessageTO> mensagens = maquinaRecepcao.trataDados(dados, bytesLidos);
                        trataMensagensRecebidas(mensagens);
                    }
                } while (bytesLidos != -1);
            } finally {
                if (stream != null) {
                    stream.close();
                }
                if (clientSocket.isConnected()) {
                    clientSocket.close();
                }
            }
        } catch (IOException ex) {
            if (ex.getMessage().equals("Socket closed")) {
                System.out.println(clientSocket.hashCode() + ": Conexão cliente encerrada");
            } else {
                Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    /**
     * @return the clientSocket
     */
    public Socket getClientSocket() {
        return clientSocket;
    }

    /**
     * 6
     *
     * @param clientSocket the clientSocket to set
     */
    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void encerra() throws IOException {
        if (clientSocket.isConnected()) {
            clientSocket.close();
        }
    }

    void identifiqueSe() {
        if ((clientSocket.isConnected()) && (!clientSocket.isClosed())) {
            System.out.println(clientSocket.hashCode() + ": Conexão cliente estabelecida.");
        } else {
            System.out.println(clientSocket.hashCode() + ": Conexão cliente encerrada.");
        }
    }

    private void trataMensagensRecebidas(List<MessageTO> mensagens) {
        for (MessageTO msg : mensagens) {
            switch (msg.getOpCode()) {
                case "I":
                    GerenciadorImpressao.getInstancia().adicionaMsgImpressao(msg.getMensagem());
                    break;
                case "S":
                    System.out.println(clientSocket.hashCode() + ": Mensagem de status recebida: " + msg.getMensagem());
                    break;
                default:
                    System.out.println(clientSocket.hashCode() + ": Mensagem desconhecida recebida: " + msg.getMensagem());
                    break;
            }
        }
    }
}
