/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.business.ec6.crud.config;

import br.com.comuns.crud.ec6.enums.TipoRepositorio;

/**
 *
 * @author gabriell
 */
public class Config {
    private static Config uniqueInstance;
 
    private Config() {
    }
 
    public static synchronized Config getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new Config();
 
        return uniqueInstance;
    }
    
    private TipoRepositorio tipoRepositorio; 

    public TipoRepositorio getTipoRepositorio() {
        return tipoRepositorio;
    }

    
    public void setDatabase(TipoRepositorio tipoRepositorio) {
        this.tipoRepositorio = tipoRepositorio;
    }
}
