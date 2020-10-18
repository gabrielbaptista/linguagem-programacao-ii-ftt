/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factories;

import ConcreteClasses.IoC.FreightTaxCalculatorEuro;
import ConcreteClasses.IoC.FreightTaxCalculatorReal;
import designpatterns.Interfaces.IFreightTaxCalculator;

/**
 *
 * @author gabriell
 */
public class FreightTaxCalculatorFactory {
      public static IFreightTaxCalculator factory(String option) {
        IFreightTaxCalculator calculator;
        if (option.equals("br"))
            calculator = new FreightTaxCalculatorReal();
        else
            calculator = new FreightTaxCalculatorEuro();
       return calculator;
    }
}
