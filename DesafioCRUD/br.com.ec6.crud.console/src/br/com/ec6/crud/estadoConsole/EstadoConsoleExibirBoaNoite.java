/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ec6.crud.estadoConsole;

import br.com.ec6.crud.CRUD;

/**
 *
 * @author gabriell
 */
public class EstadoConsoleExibirBoaNoite extends MaquinaEstadoConsole {

    @Override
    public boolean Executa() {
        System.out.println("Boa noite!");
        CRUD.estadoConsole = EnumEstadoConsole.MENU_PRINCIPAL.getEstadoMaquina();
        return false;
    }
}
