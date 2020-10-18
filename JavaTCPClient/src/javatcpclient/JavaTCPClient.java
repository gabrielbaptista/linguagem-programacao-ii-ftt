/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatcpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.nio.CharBuffer;

/**
 *
 * @author gabriell
 */
public class JavaTCPClient {


    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        simulaRequisicaoHTTP();
        //simulaConexaoServer();
    }

    private static void simulaRequisicaoHTTP() throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        InetAddress host = InetAddress.getLocalHost();
        SocketAddress address = new InetSocketAddress(host, 8080);
        try (Socket socket = new Socket()) {
            socket.connect(address);
            try (OutputStream out = socket.getOutputStream()) {
                try (Writer writer = new OutputStreamWriter(out)) {
                    writer.write("GET /api/about HTTP/1.0\r\n\r\n");
                    writer.flush();
                    try (InputStream in = socket.getInputStream()) {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                        StringBuilder result = new StringBuilder();
                        boolean flag = false;
                        String newLine = System.getProperty("line.separator");
                        for (String line; (line = reader.readLine()) != null; ) {
                            result.append(flag? newLine: "").append(line);
                            flag = true;
                        }
                        System.out.println("Message: " + result.toString());
                    }
                }
            }
            socket.close();
        }
    }

    private static void simulaConexaoServer() throws IOException, InterruptedException, ClassNotFoundException {
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        for(int i=0; i<5;i++){
            socket = new Socket(host.getHostName(), 9876);
            oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Sending request to Socket Server");
            if(i==4)oos.writeObject("exit");
            else oos.writeObject(""+i);
            ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Message: " + message);
            ois.close();
            oos.close();
            Thread.sleep(100);
        }
    }

    
}
