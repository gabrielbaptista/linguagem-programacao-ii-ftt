/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsample;

/**
 *
 * @author gabriell
 */
public class SampleSingleton {

    private static Object objeto = new Object();
    public static SampleSingleton _instance;

    public static SampleSingleton Instancia() {
        if (_instance == null) {
            _instance = new SampleSingleton();
        }
        return _instance;
    }

    private String variavel;

    private int valor = 0;

    /**
     * @return the variavel
     */
    public String getVariavel() {
        return variavel;
    }

    /**
     * @param variavel the variavel to set
     */
    public void setVariavel(String variavel) {
        this.variavel = variavel;
    }

    public synchronized void incrementaValor() {
        valor++;
    }

    public synchronized void decrementaValor() {
        valor--;
    }

    public int getValor() {
        return valor;
    }
}
