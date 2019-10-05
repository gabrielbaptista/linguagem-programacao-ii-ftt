/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao.ec6.crud.basis;

import br.com.comuns.ec6.crud.basis.Entidade;
import java.sql.SQLException;

/**
 *
 * @author gabriell
 */
public abstract class DAO {
    
    public abstract Entidade seleciona(int id);
    public abstract Entidade localiza(String codigo) throws SQLException;
    
}
