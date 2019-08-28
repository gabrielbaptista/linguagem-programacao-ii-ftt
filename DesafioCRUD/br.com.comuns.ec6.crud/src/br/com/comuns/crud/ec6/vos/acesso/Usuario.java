/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.comuns.crud.ec6.vos.acesso;

import br.com.comuns.ec6.crud.basis.Entidade;

/**
 *
 * @author gabriell
 */
public class Usuario extends Entidade {
    
    private String senha;
    private String login;

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return  login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
}
