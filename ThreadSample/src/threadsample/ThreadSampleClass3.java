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
public class ThreadSampleClass3 implements Runnable{

    
    
    private boolean enabled;
    
    @Override
    public void run() {
        try {
            this.setEnabled(true);
            while (enabled)
            {
                synchronized (ThreadSample.objeto)
                {
                    ThreadSample.Interacoes++;
                }
                        
                Thread.sleep(1);
                System.out.printf("%s - Execução em Loop!\n", 
                    Instant.now().toString());
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadSampleClass.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }

    public void setEnabled(boolean value) {
        this.enabled = value;
    }
}
