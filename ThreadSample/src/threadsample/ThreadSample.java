/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsample;

import java.time.Instant;

public class ThreadSample {

    public static void main(String[] args) {
        // TODO code application logic here
        ThreadSampleClass thread1 = new ThreadSampleClass();
        thread1.start();
        
        ThreadSampleClass2 runnableClass = new ThreadSampleClass2();
        Thread thread2 = new Thread(runnableClass);
        thread2.start();
        
        ThreadSampleClass3 runnableClass3 = new ThreadSampleClass3();
        Thread thread3 = new Thread(runnableClass3);
        thread3.start();
        System.out.printf("%s - Apenas um texto escrito no main Thread!\n", 
                Instant.now().toString());
        try {
            runnableClass3.setEnabled(false);
            thread3.join(); 
            System.out.println("Thread 3 encerrada corretamente");
	} catch(InterruptedException e) { 
            System.out.println(e.toString());
        }
        System.out.printf("Foram realizadas %d interações\n", Interacoes);
    }
}