/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ec6.crud;

import br.com.ec6.crud.estadoConsole.EstadoConsoleMenuPrincipal;
import br.com.ec6.crud.estadoConsole.MaquinaEstadoConsole;
import br.com.ec6.crud.estadoConsole.EstadoConsoleBemVindo;
import br.com.ec6.crud.estadoConsole.EstadoConsoleLogin;

/**
 *
 * @author gabriell
 */
public class CRUD {

    public static MaquinaEstadoConsole estadoConsole;
    public static final EstadoConsoleBemVindo BEM_VINDO = new EstadoConsoleBemVindo();
    public static final EstadoConsoleLogin LOGIN = new EstadoConsoleLogin();
    public static final EstadoConsoleMenuPrincipal MENU_PRINCIPAL = new EstadoConsoleMenuPrincipal();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        estadoConsole = BEM_VINDO;
        Boolean saida = false;
        while (!saida){
            saida = estadoConsole.Executa();
        }
    }
    
}
