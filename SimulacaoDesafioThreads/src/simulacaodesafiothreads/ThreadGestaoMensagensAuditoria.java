/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacaodesafiothreads;

import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriell
 */
public class ThreadGestaoMensagensAuditoria extends Thread {

    private boolean status;

    @Override
    public void run() {
        setStatus(true);
        while (status) {
            try {
                String msg = GerenciadorAuditoria.getInstancia().retiraMsgAuditoria();
                if (msg != null) {
                    enviaMensagemParaSistemaAuditoria(msg);
                }
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadGestaoMensagensAuditoria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setStatus(boolean value) {
        status = value;
    }

    private void enviaMensagemParaSistemaAuditoria(String msg) throws InterruptedException {
        System.out.printf("%s - Valor %s\n", Instant.now().toString(), msg);
        Thread.sleep(100);
    }
}
