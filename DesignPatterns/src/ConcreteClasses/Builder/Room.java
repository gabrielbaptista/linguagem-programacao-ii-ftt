/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConcreteClasses.Builder;

/**
 *
 * @author gabriell
 */
public class Room {

    private String name;
    private Boolean wiFiFreeOfCharge;
    private int numberOfBeds;
    private Boolean balconyAvailable;

    public Room(String name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the wiFiFreeOfCharge
     */
    public Boolean getWiFiFreeOfCharge() {
        return wiFiFreeOfCharge;
    }

    /**
     * @param wiFiFreeOfCharge the wiFiFreeOfCharge to set
     */
    public void setWiFiFreeOfCharge(Boolean wiFiFreeOfCharge) {
        this.wiFiFreeOfCharge = wiFiFreeOfCharge;
    }

    /**
     * @return the numberOfBeds
     */
    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    /**
     * @param numberOfBeds the numberOfBeds to set
     */
    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    /**
     * @return the balconyAvailable
     */
    public Boolean getBalconyAvailable() {
        return balconyAvailable;
    }

    /**
     * @param balconyAvailable the balconyAvailable to set
     */
    public void setBalconyAvailable(Boolean balconyAvailable) {
        this.balconyAvailable = balconyAvailable;
    }

    public void Describe() {
        String wifi = wiFiFreeOfCharge ? "is" : "is not";
        String balcony = balconyAvailable ? "is" : "is not";
        System.out.println(this.getName() + " room");
        System.out.println("Number of bed(s): " + this.getNumberOfBeds());
        System.out.println("There " + balcony + " a balcony.");
        System.out.println("This room " + wifi + " wi-fi Free");
        System.out.println("");
    }
}
