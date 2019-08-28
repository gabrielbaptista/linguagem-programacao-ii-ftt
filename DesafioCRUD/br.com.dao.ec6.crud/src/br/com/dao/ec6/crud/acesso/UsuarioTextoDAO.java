/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao.ec6.crud.acesso;

import br.com.comuns.crud.ec6.enums.EntidadesDisponiveis;
import br.com.comuns.crud.ec6.vos.acesso.Usuario;
import br.com.comuns.ec6.crud.basis.Entidade;
import br.com.comuns.ec6.crud.basis.FabricaEntidades;
import br.com.dao.ec6.crud.basis.DAO;
import java.awt.List;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 *
 * @author gabriell
 */
public class UsuarioTextoDAO extends DAO {

    private final Hashtable<String, Usuario> usuarios = new Hashtable<String, Usuario>();
    
    public UsuarioTextoDAO()
    {
        Usuario masterUser = new Usuario();
        masterUser.setLogin("master");
        masterUser.setSenha("master");        
        usuarios.put("master", masterUser);
    }
    @Override
    public Entidade seleciona(int id) {
        // Não há retorno por id
        return null;
    }

    @Override
    public Entidade localiza(String codigo) {
        Entidade entidade = usuarios.getOrDefault(codigo, null);
        return entidade;
    }
    
}
