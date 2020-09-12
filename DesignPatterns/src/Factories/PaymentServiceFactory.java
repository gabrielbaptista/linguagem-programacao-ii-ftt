/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factories;

import ConcreteClasses.Factory.BrazilianPaymentService;
import ConcreteClasses.Factory.ItalianPaymentService;
import designpatterns.Interfaces.IPaymentService;

/**
 *
 * @author gabriell
 */
public class PaymentServiceFactory {
    
    public static IPaymentService factory(String option) {
        IPaymentService paymentService;
        if (option.equals("br"))
            paymentService = new BrazilianPaymentService();
        else
            paymentService = new ItalianPaymentService();
       return paymentService;
    }
}
