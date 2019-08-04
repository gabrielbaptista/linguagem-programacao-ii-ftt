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
public enum Sentimento {

    /**
     *
     */
    BEM("bem"),

    /**
     *
     */
    FELIZ("feliz"),

    /**
     *
     */
    CANSADO("cansado");
 
    private String descricao;
 
    Sentimento(String descricao) {
        this.descricao = descricao;
    }
 
    public String getDescricao() {
        return descricao;
    }
}
