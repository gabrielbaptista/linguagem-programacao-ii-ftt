/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ec6.crud.estadoConsole;

import br.com.business.ec6.crud.acesso.Acesso;
import br.com.comuns.crud.ec6.vos.acesso.Usuario;
import br.com.ec6.crud.CRUD;
import java.util.Scanner;

/**
 *
 * @author gabriell
 */
public class EstadoConsoleLogin extends MaquinaEstadoConsole {

    @Override
    public boolean Executa() {
        boolean sair = false;
        Usuario user = new Usuario();
        Scanner scan = new Scanner(System.in);
        System.out.println("**** LOGIN ****");
        System.out.println("Digite seu usuário");
        user.setLogin(scan.nextLine());
        System.out.println("Digite sua senha");
        user.setSenha(scan.nextLine());
        // TODO - Validação de senha
        Acesso acesso = new Acesso();
        boolean senhaValida = acesso.validaUsuario(user);
        if (senhaValida)
            CRUD.estadoConsole = CRUD.MENU_PRINCIPAL;
        else {
            System.out.println("Dados inválidos!");
        }            
        return sair;
    }
}
