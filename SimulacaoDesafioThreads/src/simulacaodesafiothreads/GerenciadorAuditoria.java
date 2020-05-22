/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacaodesafiothreads;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriell
 */
public class GerenciadorAuditoria {

    /* Implementação do Singleton */
    private static GerenciadorAuditoria instancia;

    private GerenciadorAuditoria() {
        //filaMensagens = new ConcurrentLinkedQueue<>();
        filaMensagens = new LinkedList<>();
    }

    public static GerenciadorAuditoria getInstancia() {
        if (instancia == null) {
            instancia = new GerenciadorAuditoria();
        }
        return instancia;
    }

    /* Fim da implementação do Singleton */
    //ConcurrentLinkedQueue<String> filaMensagens;
    LinkedList<String> filaMensagens;
    ThreadGestaoMensagensAuditoria thread;

    public void adicionaMsgAuditoria(String msgAuditoria) {
        filaMensagens.add(msgAuditoria);
    }

    String retiraMsgAuditoria() {
        String msg = filaMensagens.poll();
        return msg;
    }
    
    void ativar(){
        if (thread == null){
            thread = new ThreadGestaoMensagensAuditoria();
            thread.start();
        }
    }
    
    void desativar(){
        if (thread != null) {
            thread.setStatus(false);
            try {
                thread.join(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(GerenciadorAuditoria.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (thread.isAlive())
                thread.interrupt();
        }
    }
}
