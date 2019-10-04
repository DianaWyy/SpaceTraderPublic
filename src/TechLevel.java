
/**
 * This enum represents all the 7 possible TechLevels for a region
 * @author Haorong She
 * @version 0.1
 */
public enum TechLevel {

    PREAG("Pre-Agriculture", 1),
    AGRICULTURE("Agriculture", 2),
    MEDIEVAL("Medieval", 3),
    RENAISSANCE("Renaissance", 4),
    INDUSTRIAL("Industrial", 5),
    MODERN("Modern", 6),
    FUTURISTIC("Futuristic", 7);


    private String name;
    private int level;

    /**
     * Constructor for TechLevel, private only
     */
    private TechLevel(String name, int level) {
        this.name = name;
        this.level = level;
    }

    /**
     * TechLevel name getter method
     * @return the TechLevel name in string
     */
    public String getName() {
        return this.name;
    }

    /**
     * TechLevel integer getter method
     * @return the TechLevel in int
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * TechLevel random level getter
     * @return a random level in the enum
     */
    public static TechLevel getRandomTechLevel() {
        return values()[(int)(Math.random()*8)];
    }
}

