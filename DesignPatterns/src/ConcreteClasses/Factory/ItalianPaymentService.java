/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConcreteClasses.Factory;

import ConcreteClasses.IoC.FreightTaxCalculator;
import designpatterns.Interfaces.IFreightTaxCalculator;
import designpatterns.Interfaces.IPaymentService;

/**
 *
 * @author gabriell
 */
public class ItalianPaymentService extends PaymentService implements IPaymentService {

    public ItalianPaymentService(IFreightTaxCalculator freight) {
        super(freight);
    }
    
    @Override
    public void processCharging() {
        System.out.println("IT");
        System.out.println("Trasporto: €" + getFreightTaxCalculator().calculateFreight());
    }    

    
}

