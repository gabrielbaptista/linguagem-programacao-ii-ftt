/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula02;

/**
 *
 * @author gabriell
 */
public class Aula02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Curintiano gabriel = new Curintiano("Gabriel", Sentimento.BEM);
        Pessoa denise = new Pessoa("Denise", Sentimento.FELIZ);
        gabriel.DizerOlaPara(denise);
        denise.DizerOlaPara(gabriel);
        gabriel.PerguntarComoEsta(denise);
        denise.DizerSentimento();
                
    }
    
}
