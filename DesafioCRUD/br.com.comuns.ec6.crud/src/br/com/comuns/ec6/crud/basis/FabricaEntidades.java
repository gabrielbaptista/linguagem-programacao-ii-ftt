/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.comuns.ec6.crud.basis;

import br.com.comuns.crud.ec6.enums.EntidadesDisponiveis;
import br.com.comuns.crud.ec6.vos.acesso.Usuario;
import br.com.comuns.crud.ec6.vos.conteudo.Pedido;

/**
 *
 * @author gabriell
 */
public class FabricaEntidades {
    
    public static Entidade Fabrica(EntidadesDisponiveis enumEntidade) {
        Entidade retorno;
        switch (enumEntidade)
        {
            case USUARIO:
                retorno = new Usuario();
                break;
            case PEDIDO:
                retorno = new Pedido();
                break;
            default:
                retorno = new Entidade();
                break;
        }
        return retorno;
    }
}
