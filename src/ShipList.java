/**
 * This enum represents all the ship models this game have
 * @author Haorong She
 * @version 0.1
 */
public enum ShipList {


    //ship models, can create more if needed
    SIDEWINDER("Battle", 12, 8, 100),
    EAGLEMKII("Battle", 8, 12, 120),
    HAULER("Trade", 30, 16, 80),
    PYTHON("Trade", 36, 20, 100),
    EXPLORER("Explore", 20, 40, 60),
    FEDERAL("Battle", 24, 20, 200),
    ANACONDA("Battle", 24, 20, 200);


    //instance vars
    private String type;
    private int cargoSpace;
    private int fuelCapacity;
    private int health;


    //private constructor
    private ShipList(String type, int cargoSpace, int fuelCapacity, int health) {
        this.type = type;
        this.cargoSpace = cargoSpace;
        this.fuelCapacity = fuelCapacity;
        this.health = health;
    }


    //getters
    public String getType() {
        return this.type;
    }

    public int getCargoSpace() {
        return this.cargoSpace;
    }

    public int getFuelCapacity() {
        return this.fuelCapacity;
    }

    public int getHealth() {
        return this.health;
    }
}
