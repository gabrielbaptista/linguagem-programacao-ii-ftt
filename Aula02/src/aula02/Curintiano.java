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
public class Curintiano extends Pessoa {
    
    public Curintiano(String nome, Sentimento sentimento) {
        super(nome, sentimento);
    }
    
    @Override
    public void DizerOlaPara(Pessoa pessoa){
        System.out.println(this.getNome()+ ": E aí, mano "+ pessoa.getNome()+"!");
    }
     
    @Override
    public void PerguntarComoEsta(Pessoa pessoa){
        System.out.println(this.getNome()+ ": Qual é a tua?");
    }
    
}
