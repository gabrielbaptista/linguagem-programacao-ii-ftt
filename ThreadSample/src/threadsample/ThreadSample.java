/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsample;

import java.time.Instant;

public class ThreadSample {

    public static void main(String[] args) {
        ThreadSampleClass thread1 = new ThreadSampleClass();
        thread1.start();
        
        
        System.out.printf("%s - Apenas um texto escrito no main Thread!\n", 
                Instant.now().toString());
        try {
            thread1.join(); 
            System.out.printf("%s - Thread 1 encerrada corretamente\n", 
                Instant.now().toString());
	} catch(InterruptedException e) { 
            System.out.println(e.toString());
        }
        System.out.printf("%s - Main Thread Concluída\n", 
                Instant.now().toString());
    }
}