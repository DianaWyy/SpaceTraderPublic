public enum Item {
   

    //PREAG
    Stone("Stone", 5, TechLevel.PREAG),
    Plant("Plant", 7, TechLevel.PREAG),
    PureWater("Pure Water", 10, TechLevel.PREAG),
    //AGRICULTURE
    Rice("Rice", 20, TechLevel.AGRICULTURE),
    Flour("Flour", 20, TechLevel.AGRICULTURE),
    Wood("Wood", 30, TechLevel.AGRICULTURE),
    //MEDIEVAL
    Paper("Paper", 50, TechLevel.MEDIEVAL),
    Tea("Tea", 70, TechLevel.MEDIEVAL),
    Medicine("Medicine", 90, TechLevel.MEDIEVAL),
    Gold("Gold", 100, TechLevel.MEDIEVAL),
    //RENAISSANCE
    Painting("Painting", 120, TechLevel.RENAISSANCE),
    Bible("Bible", 150, TechLevel.RENAISSANCE),
    Poetry("Poetry", 120, TechLevel.RENAISSANCE),
    //INDUSTRIAL
    Compass("Compass", 300, TechLevel.INDUSTRIAL),
    Bomb("Bomb", 400, TechLevel.INDUSTRIAL),
    Weapon("Weapon", 500, TechLevel.INDUSTRIAL),
    //MODERN
    SmartPhone("Smart Phone", 800, TechLevel.MODERN),
    Computers("Computers", 1500, TechLevel.MODERN),
    Pad("Pad", 2500, TechLevel.MODERN),
    //FUTURISTIC
    Doraemon("Doraemon", 5000, TechLevel.FUTURISTIC),
    GlassScreeen("GlassScreen", 5000, TechLevel.FUTURISTIC);





    private String name;
    private int price;
    private TechLevel techlevel;

    private Item(String name, int price, TechLevel techlevel) {
        this.name = name;
        this.price = price;
        this.techlevel = techlevel;
    }


}
