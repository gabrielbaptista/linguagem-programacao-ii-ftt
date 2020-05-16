/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsample;

import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author gabriell
 */
public class ThreadPesadelo extends Thread {
    @Override
    public void run(){
         while (true) {
                SampleSingleton.Instancia().incrementaValor();
             try {
                 Thread.sleep(1);
             } catch (InterruptedException ex) {
                 Logger.getLogger(ThreadPesadelo.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
    }            
}
