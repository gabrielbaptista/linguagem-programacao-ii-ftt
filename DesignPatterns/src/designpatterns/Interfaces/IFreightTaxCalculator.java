/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.Interfaces;

/**
 *
 * @author gabriell
 */
public interface IFreightTaxCalculator {

    double calculateFreight();

    /**
     * @param from the from to set
     */
    void setFrom(int from);

    /**
     * @param to the to to set
     */
    void setTo(int to);
    
}
