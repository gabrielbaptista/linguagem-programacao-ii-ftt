/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.business.ec6.crud.basis;

import br.com.business.ec6.crud.config.Config;
import br.com.comuns.crud.ec6.enums.TipoRepositorio;
import br.com.dao.ec6.crud.repositiorio.mysql.RepositorioMySQL;
import br.com.dao.ec6.crud.repositorio.arquivo.RepositorioArquivos;
import br.com.dao.ec6.crud.repositorio.basis.Repositorio;


/**
 *
 * @author gabriell
 */
public class  FabricaRepositorio {

    public static Repositorio Fabrica() {
        if (Config.getInstance().getTipoRepositorio() == TipoRepositorio.MYSQL)
            return new RepositorioMySQL();
        else
            return new RepositorioArquivos();
    }
}
