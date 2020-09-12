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
public interface IPaymentService {
    void setEmailToCharge(String email);
    void setMoneyToCharge(Double money);
    void setOptionToCharge(String option);
    void processCharging();
}
