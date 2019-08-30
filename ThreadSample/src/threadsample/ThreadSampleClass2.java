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
public class ThreadSampleClass2 implements Runnable{

    @Override
    public void run() {
        try {
            
            synchronized (ThreadSample.objeto)
                {
                    ThreadSample.Interacoes++;
                }
            Thread.sleep(1000);
            System.out.printf("%s - Execução de Thread com interface Runnable!\n", 
                    Instant.now().toString());
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadSampleClass.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }
}
