/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Directors;

import ConcreteClasses.Builder.Room;
import designpatterns.Interfaces.IRoomBuilder;

/**
 *
 * @author gabriell
 */
public class DirectorRooms {

    private IRoomBuilder _roomBuilder;

    public DirectorRooms(IRoomBuilder roomBuilder) {
        _roomBuilder = roomBuilder;
    }

    public Room construct() {
        _roomBuilder.buildBalcony();
        _roomBuilder.buildWifi();
        _roomBuilder.buildBed();
        return _roomBuilder.build();
    }

}
