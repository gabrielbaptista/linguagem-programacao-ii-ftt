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
public class ThreadSampleClass extends Thread {
    @Override
    public void run(){
        try {
            System.out.printf("%s - Início da execução de Thread com herança!\n", 
                    Instant.now().toString());
            Thread.sleep(5000);            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadSampleClass.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        System.out.printf("%s - Fim da execução da Thread com herança!\n", 
                    Instant.now().toString());
    }            
}
