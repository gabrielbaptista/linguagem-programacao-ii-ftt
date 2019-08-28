/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao.ec6.crud.basis;

import br.com.comuns.crud.ec6.enums.EntidadesDisponiveis;
import br.com.comuns.crud.ec6.enums.TipoRepositorio;
import br.com.dao.ec6.crud.acesso.UsuarioTextoDAO;

/**
 *
 * @author gabriell
 */
public class FabricaDAOs {
    
    public static DAO Fabrica(EntidadesDisponiveis enumEntidade, TipoRepositorio repositorio) {
        switch (repositorio)
        {
            case TEXTO:
                return MontaDAOTexto(enumEntidade);
            default:
                return null;
        }
       
    }

    private static DAO MontaDAOTexto(EntidadesDisponiveis enumEntidade) {
        DAO retorno;
        switch (enumEntidade)
        {
            case USUARIO:
                retorno = new UsuarioTextoDAO();
                break;            
            default:
                retorno = null;
                break;
        }
        return retorno;    
    }
    
}
