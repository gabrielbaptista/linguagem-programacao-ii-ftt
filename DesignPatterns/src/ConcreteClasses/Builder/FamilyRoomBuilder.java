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
public class FamilyRoomBuilder implements IRoomBuilder {

    private Room room;
    public FamilyRoomBuilder() {
        room = new Room("Family Room");
    }
    
    @Override
    public void buildWifi() {
        room.setWiFiFreeOfCharge(true);
    }

    @Override
    public void buildBed() {
        room.setNumberOfBeds(3);
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
