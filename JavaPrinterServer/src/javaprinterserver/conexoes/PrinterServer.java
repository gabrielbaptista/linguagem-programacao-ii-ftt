/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprinterserver.conexoes;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriell
 */
public class PrinterServer extends Thread {

    private static ServerSocket server;
    private static int port = 11340;
    private boolean servidorAtivo;
    private List<ClientManager> clientesConectados = Collections.synchronizedList(new ArrayList<ClientManager>());


    @Override
    public void run() {
        try {
            servidorAtivo = true;
            server = new ServerSocket(port);
            while (servidorAtivo) {
                System.out.println("Aguardando nova conexão com PrinterServer...");
                Socket socket = server.accept();
                adicionaClientParaTratamento(socket);
                Thread.sleep(10);
            }
            if (!server.isClosed()) {
                server.close();
            }
        } catch (IOException | InterruptedException ex) {
            if (ex.getMessage().equals("socket closed")) {
                System.out.println("Conexão server encerrada...");
            } else {
                Logger.getLogger(PrinterServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void adicionaClientParaTratamento(Socket socket) {
        ClientManager manager = new ClientManager();
        manager.setClientSocket(socket);
        clientesConectados.add(manager);
        Thread threadSocket = new Thread(manager);
        threadSocket.start();
    }

    public void encerra() throws IOException {
        clientesConectados.forEach((cliente) -> {
            try {
                cliente.encerra();
            } catch (IOException ex) {
                Logger.getLogger(PrinterServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        servidorAtivo = false;
        server.close();
    }

    public void listarClientes() {
        for (ClientManager cliente : clientesConectados){
                cliente.identifiqueSe();
        }
    }
}
