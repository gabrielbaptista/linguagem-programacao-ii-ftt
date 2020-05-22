package simulacaodesafiothreads;


import java.util.logging.Level;
import java.util.logging.Logger;
import simulacaodesafiothreads.GerenciadorAuditoria;
import simulacaodesafiothreads.ThreadGestaoMensagensAuditoria;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gabriell
 */
public class ThreadBomba extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                GerenciadorAuditoria.getInstancia().adicionaMsgAuditoria("Bomba " + i);
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadBomba.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
