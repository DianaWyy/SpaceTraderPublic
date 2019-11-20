
import java.util.*;

//please add a ship reference in Player class.
//so we can assign a Ship object to a player


/**
 * This class represents a ship object
 *
 * @author Haorong She
 * @version 0.1
 */
public class Ship {

    private String type;  //ship type, Battle/Trade/Explorer

    private int cargoSpace;      //total
    private int currCargoSpace;  //current available

    private double fuelCapacity;
    private double currFuelCapacity;

    private int health;
    private int currHealth;

    private static Ship[] ships = {
            new Ship("Basic", 15, 20, 50),
            new Ship("Battle", 15, 20, 100),
            new Ship("Explorer", 15, 40, 50),
            new Ship("Trade", 30, 20, 50)
    };


    private ArrayList<Item> cargoList;


    //constructor
    public Ship(String type, int cargoSpace, int fuelCapacity, int health) {
        this.type = type;
        this.cargoSpace = cargoSpace;
        this.currCargoSpace = 0;
        this.fuelCapacity = fuelCapacity;
        this.currFuelCapacity = fuelCapacity;
        this.health = health;
        this.currHealth = health;
        this.cargoList = new ArrayList<Item>();
    }

    //Gets Basic Ship
    public static Ship getBasicShip() {
        return ships[0];
    }

    // Gets New Basic Ship
    public static Ship getNewBasicShip() {
        Ship s = getBasicShip();
        s.currCargoSpace = 0;
        s.currFuelCapacity = s.fuelCapacity;
        s.currHealth = s.health;
        s.cargoList.clear();
        return s;
    }

    //Gets Basic Ship
    public static Ship getBattleShip() {
        return ships[1];
    }

    //Gets Basic Ship
    public static Ship getExplorerShip() {
        return ships[2];
    }

    //Gets Basic Ship
    public static Ship getTradeShip() {
        return ships[3];
    }

    public ArrayList<Ship> getShipList() {
        ArrayList<Ship> shiplist = new ArrayList<>();
        Collections.addAll(shiplist, ships);
        return shiplist;
    }

    public ArrayList<String> getShipNameList() {
        ArrayList<String> nameList = new ArrayList<>();
        for (Ship s : ships) {
            nameList.add(String.format("%s | Cargo Space: %d, Fuel Capacity: %.2f, Health: %d",
                    s.getType(), s.getCargoSpace(), s.getFuelCapacity(), s.getHealth()));
        }
        return nameList;
    }

    //getters and setters
    public String getType() {
        return this.type;
    }

    public void setCargoSpace(int cargoSpace) {
        this.cargoSpace = cargoSpace;
    }

    public int getCargoSpace() {
        return this.cargoSpace;
    }

    //    public void setCurrCargoSpace(int currCargoSpace) {
    //        this.currCargoSpace = currCargoSpace;
    //    }

    public int getCurrCargoSpace() {
        return this.currCargoSpace;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public double getFuelCapacity() {
        return this.fuelCapacity;
    }

    public void decreaseCurrFuelCapacity(double currFuelCapacity) {
        this.currFuelCapacity -= currFuelCapacity;
    }

    public double getCurrFuelCapacity() {
        return this.currFuelCapacity;
    }

    public void setCurrFuelCapacity(double cfc) {
        this.currFuelCapacity = cfc;
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

    public ArrayList<Item> getCargoList() {
        return cargoList;
    }

    public ArrayList<String> getCargoNameList() {
        ArrayList<String> nameList = new ArrayList<>();
        for (Item item : cargoList) {
            nameList.add(String.format("$%d %s", item.getPrice(), item.getName()));
        }
        return nameList;
    }


    //add, remove, clear cargolist
    public void addCargo(Item item) {
        cargoList.add(item);
        currCargoSpace++;
    }

    public void removeCargo(Item item) {
        cargoList.remove(item);
        currCargoSpace--;
    }

    public void clearCargo() {
        cargoList = new ArrayList<Item>();
    }
}