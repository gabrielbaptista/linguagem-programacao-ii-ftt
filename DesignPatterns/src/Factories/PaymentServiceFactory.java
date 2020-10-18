/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factories;

import ConcreteClasses.Factory.BrazilianPaymentService;
import ConcreteClasses.Factory.ItalianPaymentService;
import designpatterns.Interfaces.IFreightTaxCalculator;
import designpatterns.Interfaces.IPaymentService;

/**
 *
 * @author gabriell
 */
public class PaymentServiceFactory {
    
    public static IPaymentService factory(String option, IFreightTaxCalculator freight) {
        IPaymentService paymentService;
        if (option.equals("br"))
            paymentService = new BrazilianPaymentService(freight);
        else
            paymentService = new ItalianPaymentService(freight);
       return paymentService;
    }
}
