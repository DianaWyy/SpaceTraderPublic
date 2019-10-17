import java.awt.image.BufferedImage;


public class Region {
    private int xCoordinate;
    private int yCoordinate;
    private TechLevel techlevel;
    private String name;


    public Region(int x, int y, String n) {
        xCoordinate = x;
        yCoordinate = y;
        techlevel = TechLevel.getRandomTechLevel();
        name = n;
    }



    public boolean tooClose(Region r) {
        return (Math.abs(xCoordinate - r.getXCoordinate()) < 5
                || Math.abs(yCoordinate - r.getYCoordinate()) < 5);
    }


    public void setxCoordinate(int x) {
        xCoordinate = x;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setyCoordinate(int y) {
        yCoordinate = y;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public TechLevel getTechlevel() {
        return techlevel;
    }

}
