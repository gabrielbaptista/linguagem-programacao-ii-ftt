/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao.ec6.crud.acesso;

import br.com.comuns.crud.ec6.vos.acesso.Usuario;
import br.com.comuns.ec6.crud.basis.Entidade;
import br.com.dao.ec6.crud.basis.MySQLDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriell
 * @param <E>
 */
public class UsuarioMySQLDAO <E extends Entidade> extends MySQLDAO {
    public UsuarioMySQLDAO() {
        super(Usuario.class);
    }

    @Override
    public E localiza(String codigo) throws SQLException {
        return (E)super.localiza(codigo);
    }
    
    @Override
    protected String getLocalizaCommand() {
        return "select * from tbUsuario where login = ?";
    }
       
    @Override
    protected E preencheEntidade(ResultSet rs) {
        Usuario entidade = (Usuario)super.getInstanceOfE();
        try {
            entidade.setLogin(rs.getString("Login"));
            entidade.setSenha(rs.getString("Senha"));
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioMySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (E)entidade;
    }
    
    
    @Override
    public Entidade seleciona(int id) {
        // Não há retorno por id
        return null;
    }
    @Override
    protected String getListaCommand() {
        return "select * from tbUsuario";
    }
}
