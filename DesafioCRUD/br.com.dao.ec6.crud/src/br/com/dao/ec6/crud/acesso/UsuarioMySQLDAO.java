/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao.ec6.crud.acesso;

import br.com.comuns.crud.ec6.vos.acesso.Usuario;
import br.com.comuns.ec6.crud.basis.Entidade;
import br.com.dao.ec6.crud.basis.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author gabriell
 */
public class UsuarioMySQLDAO extends DAO {
    
    public UsuarioMySQLDAO()
    {
        
    }
    @Override
    public Entidade seleciona(int id) {
        // Não há retorno por id
        return null;
    }

    /**
     *
     * @param codigo
     * @return
     * @throws SQLException
     */
    @Override
    public Entidade localiza(String codigo) throws SQLException {
        Usuario entidade = new Usuario();
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/mysample", "root", "")) {
            System.out.println("Conectado!");
            // ? => binding
            String SQL = "select * from tbUsuario where login = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(SQL)) {
                stmt.setString(1, codigo);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.first()){
                        entidade.setLogin(rs.getString("Login"));
                        entidade.setSenha(rs.getString("Senha"));
                    }
                }
            }
        }
        
        return entidade;
    }
}
