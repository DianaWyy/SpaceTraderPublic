/**
 * This enum represents all the ship models this game have
 * @author Haorong She
 * @version 0.1
 */
public enum ShipList {

    //put in new ship models
    PREAG("Pre-Agriculture", 1),
    AGRICULTURE("Agriculture", 2),
    MEDIEVAL("Medieval", 3),
    RENAISSANCE("Renaissance", 4),
    INDUSTRIAL("Industrial", 5),
    MODERN("Modern", 6),
    FUTURISTIC("Futuristic", 7);


    private String type;
    private int cargoSpace;
    private int fuelCapacity;
    private int health;

    private ShipList(String type, int cargoSpace, int fuelCapacity, int health) {
        this.type = type;
        this.cargoSpace = cargoSpace;
        this.fuelCapacity = fuelCapacity;
        this.health = health;
    }


    //getters
}
