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
public class RunnableThreadSampleClass implements Runnable{	

    @Override	
    public void run() {	
        try {	
            System.out.printf("%s - Início da Execução de Thread com interface Runnable!\n", 	
                    Instant.now().toString());	
            Thread.sleep(1000);	
            
        } catch (InterruptedException ex) {	
            Logger.getLogger(ThreadSampleClass.class.getName()).log(	
                    Level.SEVERE, null, ex);	
        }	
        System.out.printf("%s - Fim da Execução da Thread com interface Runnable!\n", 
                    Instant.now().toString());
    }	
}
