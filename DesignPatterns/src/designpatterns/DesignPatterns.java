/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

import ConcreteClasses.Builder.*;
import ConcreteClasses.IoC.FreightTaxCalculator;
import Directors.DirectorRooms;
import Factories.FreightTaxCalculatorFactory;
import Factories.PaymentServiceFactory;
import designpatterns.Interfaces.IFreightTaxCalculator;
import designpatterns.Interfaces.IPaymentService;

/**
 *
 * @author gabriell
 */
public class DesignPatterns {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        DirectorRooms director = new DirectorRooms(new FamilyRoomBuilder());
        Room room =  director.construct();
        room.Describe();
        */
        
        String localizacao = "it";
        IFreightTaxCalculator freight = FreightTaxCalculatorFactory.factory(localizacao);
        freight.setFrom(10);
        freight.setTo(20);
        IPaymentService service = PaymentServiceFactory.factory(localizacao,  freight);
        service.processCharging();
    }
    
}

