//please add a ship reference in Player class.
//so we can assign a Ship object to a player

/**
 * This class represents a ship object
 * @author Haorong She
 * @version 0.1
 */
public class Ship {

    private String type;  //ship type, assult/trade/travel etc.

    private int cargoSpace;      //total
    private int currCargoSpace;  //current available

    private int fuelCapacity;
    private int currFuelCapacity;

    private int health;
    private int currHealth;

    private ArrayList<Cargo> cargoList;  //TODO: in future implement a Cargo class to represent cargo objects

    public Ship(String type, int cargoSpace, int fuelCapacity, int health) {
        this.type = type;
        this.cargoSpace = cargoSpace;
        this.currCargoSpace = cargoSpace;
        this.fuelCapacity = fuelCapacity;
        this.currFuelCapacity = fuelCapacity;
        this.health = health;
        this.currHealth = health;
        this.cargoList = new ArrayList<Cargo>();
    }


    //getters and setters
    //add, remove, clear cargolist
}