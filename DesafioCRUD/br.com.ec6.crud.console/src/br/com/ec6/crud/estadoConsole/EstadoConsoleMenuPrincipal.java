/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ec6.crud.estadoConsole;

import br.com.ec6.crud.CRUD;
import br.com.ec6.crud.estadoConsole.MaquinaEstadoConsole;
import java.util.Scanner;

/**
 *
 * @author gabriell
 */
public class EstadoConsoleMenuPrincipal extends MaquinaEstadoConsole{

    @Override
    public boolean Executa() {
        System.out.println("*** Menu Principal");
        Scanner scan = new Scanner(System.in);
        System.out.println("0 - Sair");
        int opcao = scan.nextInt();
        switch (opcao)
        {
            case 0:
                CRUD.estadoConsole = CRUD.BEM_VINDO;
                break;
            case 1:
                
                break;
        }
        return false;
    }
    
}
