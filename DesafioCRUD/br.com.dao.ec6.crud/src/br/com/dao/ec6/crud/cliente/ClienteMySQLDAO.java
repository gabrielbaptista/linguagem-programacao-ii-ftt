/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao.ec6.crud.cliente;

import br.com.comuns.crud.ec6.vos.conteudo.Cliente;
import br.com.comuns.ec6.crud.basis.Entidade;
import br.com.dao.ec6.crud.basis.MySQLDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriell
 */
public class ClienteMySQLDAO <E extends Entidade> extends MySQLDAO{

    public ClienteMySQLDAO(Class entityClass) {
        super(Cliente.class);
    }

    @Override
    protected String getLocalizaCommand() {
         return "select * from tbCliente where Nome = ?";
    }

    @Override
    protected Entidade preencheEntidade(ResultSet rs) {
        Cliente entidade = new Cliente();
        try {
            entidade.setNome(rs.getString("Nome"));
            entidade.setEndereco(rs.getString("Endereco"));
        } catch (SQLException ex) {
            Logger.getLogger(ClienteMySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (E)entidade;
    }
    
}
