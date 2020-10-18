/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacaodesafiothreads;

import java.time.Instant;
import java.util.Random;

/**
 *
 * @author gabriell
 */
public class SimulacaoDesafioThreads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.printf("%s - Início da brincadeira\n", Instant.now().toString());
        GerenciadorAuditoria.getInstancia().ativar();
        try {

            
            for (int i=0;i<10;i++){
                Random rand = new Random(); //instance of random class
                int upperbound = 100;
                int proximoSleep = rand.nextInt(upperbound); 
                String msgRandomica = String.format("%s - Mensagem Rândomica de Teste %d\n", Instant.now().toString(),i+1);
                System.out.printf(msgRandomica);
                GerenciadorAuditoria.getInstancia().adicionaMsgAuditoria("Auditoria - "+msgRandomica);
                Thread.sleep(proximoSleep);
            }
            
            Thread.sleep(15000);
        } finally {
            GerenciadorAuditoria.getInstancia().desativar();
        }

        System.out.printf("%s - Final da brincadeira\n", Instant.now().toString());
    }

}
