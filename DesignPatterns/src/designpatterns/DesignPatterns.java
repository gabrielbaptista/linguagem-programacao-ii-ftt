/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

import ConcreteClasses.Builder.*;
import Directors.DirectorRooms;
import Factories.PaymentServiceFactory;
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
        // TODO code application logic here
        DirectorRooms director = new DirectorRooms(new FamilyRoomBuilder());
        Room room =  director.construct();
        room.Describe();
        
        IPaymentService service = PaymentServiceFactory.factory("it");
        service.processCharging();
    }
    
}

