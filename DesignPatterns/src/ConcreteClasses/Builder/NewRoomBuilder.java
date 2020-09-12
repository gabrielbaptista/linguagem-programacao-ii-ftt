/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConcreteClasses.Builder;

import designpatterns.Interfaces.IRoomBuilder;

/**
 *
 * @author gabriell
 */
public class NewRoomBuilder implements IRoomBuilder {

    private Room room;
    public NewRoomBuilder() {
        room = new Room("New Room");
    }
    
    @Override
    public void buildWifi() {
        room.setWiFiFreeOfCharge(false);
    }

    @Override
    public void buildBed() {
        room.setNumberOfBeds(5);
    }

    @Override
    public void buildBalcony() {
        room.setBalconyAvailable(true);
    }

    @Override
    public Room build() {
         return room;
    }
    
}
