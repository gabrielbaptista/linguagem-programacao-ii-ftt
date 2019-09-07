/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ec6.crud.estadoConsole;

/**
 *
 * @author gabriell
 */
public enum EnumEstadoConsole {
    
    BEM_VINDO(new EstadoConsoleBemVindo()),
    
    LOGIN(new EstadoConsoleLogin()),
    
    MENU_PRINCIPAL (new EstadoConsoleMenuPrincipal());
 
    private final MaquinaEstadoConsole estadoMaquina;
    
    EnumEstadoConsole(MaquinaEstadoConsole estadoMaquina) {
        this.estadoMaquina = estadoMaquina;
    }
 
    public MaquinaEstadoConsole getEstadoMaquina() {
        return estadoMaquina;
    }
}
