/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao.ec6.crud.acesso;

import br.com.comuns.crud.ec6.vos.acesso.Usuario;
import br.com.comuns.ec6.crud.basis.Entidade;
import br.com.dao.ec6.crud.basis.DAO;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author gabriell
 */
public class UsuarioTextoDAO extends DAO {

    private final ConcurrentHashMap<String, Usuario> usuarios = new ConcurrentHashMap<String, Usuario>();
    
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
    public Entidade localiza(String codigo) throws SQLException  {
        Entidade entidade = usuarios.getOrDefault(codigo, null);
        return entidade;
    }
    
}
