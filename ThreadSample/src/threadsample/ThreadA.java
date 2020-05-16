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
public class ThreadA extends Thread {
    @Override
    public void run(){
        try {
            for (int i=0; i<10;i++){
                SampleSingleton.Instancia().incrementaValor();
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadA.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }            
}
