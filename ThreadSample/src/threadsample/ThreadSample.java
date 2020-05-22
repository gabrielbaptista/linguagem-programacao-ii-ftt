/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsample;

import java.time.Instant;

public class ThreadSample {
/*
    public static void main(String[] args) throws InterruptedException {
        ThreadPesadelo threadPesadelo = new ThreadPesadelo();
        threadPesadelo.start();
        
        while (threadPesadelo.isAlive()) {
            Thread.sleep(1000);
        }
        
        System.out.printf("%s - Main Thread Concluída\n",
                Instant.now().toString());
    }
    */
    public static void main(String[] args) throws InterruptedException {
        ThreadA threadA = new ThreadA();
        threadA.start();
        
         ThreadB threadB = new ThreadB();
        threadB.start();

        while ((threadA.isAlive()) && (threadB.isAlive())) {
            Thread.sleep(1000);
        }
        
        System.out.printf("%s - Valor %d\n",
                    Instant.now().toString(), SampleSingleton.Instancia().getValor());
            

        System.out.printf("%s - Main Thread Concluída\n",
                Instant.now().toString());
    }
    /*
    public static void main(String[] args) {
        ThreadSampleClass thread1 = new ThreadSampleClass();
        thread1.start();

        RunnableThreadSampleClass runnableClass = new RunnableThreadSampleClass();
        Thread thread2 = new Thread(runnableClass);
        thread2.start();

        System.out.printf("%s - Apenas um texto escrito no main Thread!\n",
                Instant.now().toString());
        try {
            thread1.join(2000);
            if (thread1.isAlive())
            {
                System.out.printf("%s - Thread 1 será morta forçadamente\n",
                    Instant.now().toString());
                thread1.interrupt();
            }
            else
                System.out.printf("%s - Thread 1 encerrada corretamente\n",
                    Instant.now().toString());
            thread2.join();
            System.out.printf("%s - Thread 2 encerrada corretamente\n",
                    Instant.now().toString());
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
        System.out.printf("%s - Main Thread Concluída\n",
                Instant.now().toString());
    }
     */
}
