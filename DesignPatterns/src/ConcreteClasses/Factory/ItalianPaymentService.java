/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConcreteClasses.Factory;

import designpatterns.Interfaces.IPaymentService;

/**
 *
 * @author gabriell
 */
public class ItalianPaymentService extends PaymentService implements IPaymentService {
    
    @Override
    public void processCharging() {
        System.out.println("IT");
    }    

    
}

