
public class Region {
    private int xCoordinate;
    private int yCoordinate;
    private TechLevel techlevel;
    private String name;
//    private Market market;
    private boolean winGame;

    public Region(int x, int y, String n) {
        xCoordinate = x;
        yCoordinate = y;
        techlevel = TechLevel.getRandomTechLevel();
        name = n;
    }

    public void setWinGame() {
        winGame = true;
    }

    public boolean isWinGame() {
        return winGame;
    }

    public double computeDistance(Region r) {
        return Math.pow(Math.pow(this.getXCoordinate() - r.getXCoordinate(), 2)
                + Math.pow(this.getYCoordinate() - r.getYCoordinate(), 2), 0.5);
    }

    public boolean tooClose(Region r) {
        return (Math.abs(xCoordinate - r.getXCoordinate()) < 5
                || Math.abs(yCoordinate - r.getYCoordinate()) < 5);
    }

//    public void setxCoordinate(int x) {
//        xCoordinate = x;
//    }

    public int getXCoordinate() {
        return xCoordinate;
    }

//    public void setyCoordinate(int y) {
//        yCoordinate = y;
//    }

    public int getYCoordinate() {
        return yCoordinate;
    }

//    public void setName(String n) {
//        name = n;
//    }

    public String getName() {
        return name;
    }

    public TechLevel getTechlevel() {
        return techlevel;
    }
//
//    public int priceCalculator(Item item) {
//        return (int) (item.getPrice() * techlevel.getLevel() * 0.25);
//    }
//
//    public Market getMarket() {
//        return market;
//    }


}