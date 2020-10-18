/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConcreteClasses.Factory;

import designpatterns.Interfaces.IFreightTaxCalculator;
import designpatterns.Interfaces.IPaymentService;

/**
 *
 * @author gabriell
 */
public abstract class PaymentService {
    private String email;
    private Double money;
    private String option;
    private IFreightTaxCalculator _freight;
    
    public PaymentService(IFreightTaxCalculator freight){
        _freight = freight;
    }
    
    protected IFreightTaxCalculator getFreightTaxCalculator(){
        return _freight;
    }
    
    public void setEmailToCharge(String email) {
        this.email = email;
    }

    public void setMoneyToCharge(Double money) {
        this.money = money;
    }

    public void setOptionToCharge(String option) {
        this.option = option;
    }
}
