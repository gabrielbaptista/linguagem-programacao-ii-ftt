/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.business.ec6.crud.acesso;

import br.com.business.ec6.crud.basis.FabricaRepositorio;
import br.com.comuns.crud.ec6.enums.EntidadesDisponiveis;
import br.com.comuns.crud.ec6.vos.acesso.Usuario;
import br.com.dao.ec6.crud.repositorio.basis.Repositorio;

/**
 *
 * @author gabriell
 */
public class Acesso {
    
    private boolean validaSenha(String senhaRepositorio, String senhaDigitada){
        return (senhaRepositorio.equals(senhaDigitada)); 
    }
    
    public boolean validaUsuario(Usuario user) {
        boolean retorno = false;
        Repositorio repositorio = FabricaRepositorio.Fabrica();        
        Usuario usuario = (Usuario)repositorio.localiza(user.getLogin(), EntidadesDisponiveis.USUARIO);
        if (usuario != null)
        {
            retorno = validaSenha(usuario.getSenha(), user.getSenha());
        }
        return retorno;
    }
}
