/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprinterserver;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriell
 */
public class ClientManager implements Runnable {

    private Socket clientSocket;

    @Override
    public void run() {
        try {
            System.out.println("Conexão cliente estabelecida: "+clientSocket.hashCode());
            InputStream stream = clientSocket.getInputStream();
            try {
                int bytesLidos = 0;
                do {
                    byte[] dados = new byte[1024];
                    bytesLidos = stream.read(dados);
                    if (bytesLidos > 0) {
                        String dadosLidos = new String(dados, 0, bytesLidos);
                        System.out.println("Message Received: " + new String(dadosLidos));
                    }
                } while (bytesLidos != -1);
            } finally {
                if (stream != null) {
                    stream.close();
                }
                if (clientSocket.isConnected())
                    clientSocket.close();
            }
        } catch (IOException ex) {
            if (ex.getMessage().equals("Socket closed")) {
                System.out.println("Conexão cliente encerrada: "+clientSocket.hashCode());
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

    /**6
     * @param clientSocket the clientSocket to set
     */
    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void encerra() throws IOException {
        if (clientSocket.isConnected())
            clientSocket.close();
    }
}
