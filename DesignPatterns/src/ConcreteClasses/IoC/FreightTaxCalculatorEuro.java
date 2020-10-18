/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConcreteClasses.IoC;

/**
 *
 * @author gabriell
 */
public class FreightTaxCalculatorEuro extends FreightTaxCalculator {

    @Override
    protected double getDollarPrice() {
        return 0.85f;
    }
    
}
