/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao.ec6.crud.basis;

import br.com.comuns.ec6.annotations.CampoNoBanco;
import br.com.comuns.ec6.crud.basis.Entidade;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gabriell
 * @param <E>
 */
public class MySQLDAO <E extends Entidade> extends DAO {

    final String STRING_CONEXAO = "jdbc:mysql://localhost/mysample";  
    final String USUARIO = "root";  
    final String SENHA = "";
    private String tabela;
    
    public MySQLDAO(Class entityClass) {
        super(entityClass);
    }
    
    protected void setTabela(String value){
        tabela = value;
    }
    
    @Override
    public E seleciona(int id) {
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
    public E localiza (String codigo) throws SQLException {
        E entidade = null;
        try (Connection conexao = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA )) {
            String SQL = getLocalizaCommand();
            try (PreparedStatement stmt = conexao.prepareStatement(SQL)) {
                stmt.setString(1, codigo);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.first()){
                        entidade = preencheEntidade(rs);
                    }
                }
            }
        }        
        return entidade;
    }

    protected String getLocalizaCommand() {
        String campos = "";
        String chave = "";
        for (Field campo : entityClass.getDeclaredFields()) {            
            if (campo.isAnnotationPresent(CampoNoBanco.class)) {
                CampoNoBanco anotacao = campo.getAnnotation(CampoNoBanco.class);
                if (anotacao.chave())
                    chave = anotacao.nome();
                campos += anotacao.nome() +",";
            }
        }
        if (campos.length() >0)
            campos = campos.substring(0, campos.length()-1);
        return "select "+ campos+ " from "+ tabela +" where "+chave +" = ?";
    }

    protected String getListaCommand() {
        return "select * from " + tabela;
    }
    
    protected E preencheEntidade(ResultSet rs) {
        throw new UnsupportedOperationException("Implementar na classe filha."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ArrayList<E> lista() throws SQLException {
        ArrayList<E> entidades = new ArrayList();
        try (Connection conexao = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            System.out.println("Banco conectado!");
            // ? => binding
            String SQL = getListaCommand();
            try (PreparedStatement stmt = conexao.prepareStatement(SQL)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()){
                        E entidade = preencheEntidade(rs);
                        entidades.add(entidade);
                    }
                }
            }
        }
        
        return entidades;
      }
}
