/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprinterserver.impressao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriell
 */
public class GerenciadorImpressao {

    // Atenção! Em um ambiente com múltiplas threads não se usa componentes que
    // não sejam concurrent. Esse componente está aqui apenas para exemplificar
    // o mau uso nesse cenário.
    //LinkedList<String> filaMensagens;
    
    ConcurrentLinkedQueue<String> filaMensagens;
    

    /* Implementação do Singleton */
    private static GerenciadorImpressao instancia;

    private GerenciadorImpressao() {
        filaMensagens = new ConcurrentLinkedQueue<>();
        //filaMensagens = new LinkedList<>();
    }

    public static GerenciadorImpressao getInstancia() {
        if (instancia == null) {
            instancia = new GerenciadorImpressao();
        }
        return instancia;
    }

    /* Fim da implementação do Singleton */
    List<ThreadGestaoImpressoes> threads;

    public void adicionaMsgImpressao(String msgAuditoria) {
        filaMensagens.add(msgAuditoria);
    }

    String retiraMsgImpressao() {
        String msg = filaMensagens.poll();
        return msg;
    }

    public void ativar() {
        if (threads == null) {
            threads = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                ThreadGestaoImpressoes thread = new ThreadGestaoImpressoes();
                thread.setName("Thread " + (i + 1));
                thread.start();
                threads.add(thread);
            }
        }
    }

    public void desativar() {
        if (threads != null) {
            for (ThreadGestaoImpressoes thread : threads) {
                thread.setStatus(false);
                try {
                    thread.join(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GerenciadorImpressao.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (thread.isAlive()) {
                    thread.interrupt();
                }
            }
        }
    }
}
