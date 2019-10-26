/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatcpsample;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriell
 */
public class JavaTCPSample {

    private static ServerSocket server;
    private static int port = 9876;
    
    public static void main(String args[]) throws IOException, ClassNotFoundException, InterruptedException{
        server = new ServerSocket(port);
        while(true){
            System.out.println("Waiting for the client request");
            try (Socket socket = server.accept()) {
                try (InputStream stream = socket.getInputStream()) {        
                    boolean ativo = true;
                    while (ativo)
                    {
                        if (stream.available() != 0)
                        {
                            byte[] dados = new byte[stream.available()];
                            stream.read(dados);
                            String dadosLidos = new String(dados);
                            if (dadosLidos.equals("sair"))
                                ativo = false;
                            else
                                System.out.println("Message Received: " + new String(dados));
                        }
                        Thread.sleep(10);
                    }
                    System.out.println("Bye bye");
                }
            }
        }
    }
}
