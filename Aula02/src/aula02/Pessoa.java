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
public class Pessoa {
    
    private String nome;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    private Sentimento sentimento;  

    /**
     * @return the sentimento
     */
    public Sentimento getSentimento() {
        return sentimento;
    }

    /**
     * @param sentimento the sentimento to set
     */
    public void setSentimento(Sentimento sentimento) {
        this.sentimento = sentimento;
    }
    
    public Pessoa (String nome, Sentimento sentimento){
        this.setNome(nome);
        this.setSentimento(sentimento);
    }
    
    public void DizerOlaPara(Pessoa pessoa){
        System.out.println(this.getNome()+ ": Olá "+ pessoa.getNome()+"!");
    }
    
    public void PerguntarComoEsta(Pessoa pessoa){
        System.out.println(this.getNome()+ ": Como você está?");
    }
    
    public void DizerSentimento(){
        System.out.println(this.getNome()+ ": Eu estou "+this.getSentimento().getDescricao());
    }
}
