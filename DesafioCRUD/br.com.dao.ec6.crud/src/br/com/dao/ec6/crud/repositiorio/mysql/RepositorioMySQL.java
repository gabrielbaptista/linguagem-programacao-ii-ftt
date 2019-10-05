/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao.ec6.crud.repositiorio.mysql;

import br.com.comuns.crud.ec6.enums.EntidadesDisponiveis;
import br.com.comuns.crud.ec6.enums.TipoRepositorio;
import br.com.comuns.ec6.crud.basis.Entidade;
import br.com.dao.ec6.crud.basis.DAO;
import br.com.dao.ec6.crud.basis.FabricaDAOs;
import br.com.dao.ec6.crud.repositorio.basis.Repositorio;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriell
 */
public class RepositorioMySQL  extends Repositorio {

    @Override
    public Entidade seleciona(int id, EntidadesDisponiveis tipoEntidade) {
        DAO dao = FabricaDAOs.Fabrica(tipoEntidade, TipoRepositorio.MYSQL);
        Entidade entidade = dao.seleciona(id);
        return entidade;
    }

    @Override
    public Entidade localiza(String codigo, EntidadesDisponiveis tipoEntidade) {
        DAO dao = FabricaDAOs.Fabrica(tipoEntidade, TipoRepositorio.MYSQL);
        Entidade entidade = null;
        try {
            entidade = dao.localiza(codigo);
        } catch (SQLException ex) {
            Logger.getLogger(RepositorioMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entidade;
    }
}
