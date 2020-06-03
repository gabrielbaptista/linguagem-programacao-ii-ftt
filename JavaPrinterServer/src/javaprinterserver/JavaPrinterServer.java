/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprinterserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author gabriell
 */
public class JavaPrinterServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // A Thread principal do JavaPrinterServer vai ficar somente escutando solicitações de menu
        byte teste = 0x02;
        
        PrinterServer server = new PrinterServer();
        server.start();
        Scanner scan = new Scanner(System.in);
        try {
            boolean sair = false;
            do {
                System.out.println("Bem-vindo!");
                System.out.println("Indique a opção desejada!");
                System.out.println("0 - Sair");
                int opcao = scan.nextInt();
                switch (opcao) {
                    case 0:
                        sair = true;
                        break;
                }
            } while (!sair);
        } finally {
            scan.close();
            server.encerra();
        }
        
        
    }

}
