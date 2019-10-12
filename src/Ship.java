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


    //constructor
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
    public void setCargoSpace(int cargoSpace) {
        this.cargoSpace = cargoSpace;
    }

    public int getCargoSpace() {
        return this.cargoSpace;
    }

    public void setCurrCargoSpace(int currCargoSpace) {
        this.currCargoSpace = currCargoSpace;
    }

    public int getCurrCargoSpace() {
        return this.currCargoSpace;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public int getFuelCapacity() {
        return this.fuelCapacity;
    }

    public void setCurrFuelCapacity(int currFuelCapacity) {
        this.currFuelCapacity = currFuelCapacity;
    }

    public int getCurrFuelCapacity() {
        return this.currFuelCapacity;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public void setCurrHealth(int currHealth) {
        this.currHealth = currHealth;
    }

    public int getCurrHealth() {
        return this.currHealth;
    }

    public ArrayList<Cargo> getCargoList() {
        return cargoList;
    }


    //add, remove, clear cargolist
    public void addCargo(Cargo item) {
        cargoList.add(item);
    }

    public void removeCargo(Cargo item) {
        cargoList.remove(item);
    }

    public void clearCargo() {
        cargoList = new ArrayList<Cargo>();
    }
}