/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprinterserver.conexoes;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import javaprinterserver.enums.EnumEstadoMaquina;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javaprinterserver.tos.MessageTO;

/**
 *
 * @author gabriell
 */
public class MaquinaEstadoRecepcao {

    private EnumEstadoMaquina estado;
    private StringBuilder conteudo;
    private MessageTO mensagemEmRecepcao;
    private final Charset iso88591charset  = Charset.forName("ISO-8859-1");
                        

    public List<MessageTO> trataDados(byte[] dados, int length) {
        List<MessageTO> retorno = new LinkedList<>();
        for (int i= 0; i< length; i++) {
            switch (estado) {
                case AGUARDA_STX:
                    if (dados[i] == 0x02) {
                        estado = EnumEstadoMaquina.AGUARDA_OPCODE;
                    }
                    break;
                case AGUARDA_OPCODE:
                    mensagemEmRecepcao.setOpCode(new String(dados,i,1));
                    estado = EnumEstadoMaquina.AGUARDA_ETX;
                    break;
                case AGUARDA_ETX:
                    if (dados[i] == 0x03) {
                        mensagemEmRecepcao.setMensagem(conteudo.toString());
                        retorno.add(mensagemEmRecepcao);
                        inicializa();
                    }
                    else{
                        ByteBuffer bb = ByteBuffer.wrap(new byte[]{dados[i]});
                        conteudo.append(iso88591charset .decode(bb).toString());
                    }
                    break;
                default:
                    estado = EnumEstadoMaquina.AGUARDA_ETX;
                    break;
            }
        }
        return retorno;
    }

    public void inicializa() {
        conteudo = new StringBuilder();
        mensagemEmRecepcao = new MessageTO();
        estado = EnumEstadoMaquina.AGUARDA_STX;
    }
}
