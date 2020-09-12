/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.Interfaces;

import ConcreteClasses.Builder.Room;

/**
 *
 * @author gabriell
 */
public interface IRoomBuilder {
     void buildWifi();
     void buildBed();
     void buildBalcony();
     Room build();
}
