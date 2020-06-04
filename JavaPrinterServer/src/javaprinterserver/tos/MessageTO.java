/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprinterserver.tos;

/**
 *
 * @author gabriell
 */
public class MessageTO {
    private String OpCode;
    private String Mensagem;

    /**
     * @return the OpCode
     */
    public String getOpCode() {
        return OpCode;
    }

    /**
     * @param OpCode the OpCode to set
     */
    public void setOpCode(String OpCode) {
        this.OpCode = OpCode;
    }

    /**
     * @return the Mensagem
     */
    public String getMensagem() {
        return Mensagem;
    }

    /**
     * @param Mensagem the Mensagem to set
     */
    public void setMensagem(String Mensagem) {
        this.Mensagem = Mensagem;
    }
}
