/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ec6.crud;

import br.com.business.ec6.crud.config.Config;
import br.com.comuns.crud.ec6.enums.TipoRepositorio;
import br.com.ec6.crud.estadoConsole.EnumEstadoConsole;
import br.com.ec6.crud.estadoConsole.MaquinaEstadoConsole;

/**
 *
 * @author gabriell
 */
public class CRUD {

    public static MaquinaEstadoConsole estadoConsole;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Design Patter - Singleton
        Config.getInstance().setDatabase(TipoRepositorio.MYSQL);
        
        String repositorio = Config.getInstance().getTipoRepositorio().getDescricao();
        System.out.println("Repositório configurado para " + repositorio);
        
        estadoConsole = EnumEstadoConsole.BEM_VINDO.getEstadoMaquina();;
        Boolean saida = false;
        while (!saida) {
            saida = estadoConsole.Executa();
        }
    }
}
