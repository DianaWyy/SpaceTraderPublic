public enum Item {
   

    //PREAG
    STONE("Stone", 5, TechLevel.PREAG),
    PLANT("Plant", 7, TechLevel.PREAG),
    PUREWATER("Pure Water", 10, TechLevel.PREAG),
    //AGRICULTURE
    RICE("Rice", 20, TechLevel.AGRICULTURE),
    FLOUR("Flour", 20, TechLevel.AGRICULTURE),
    WOOD("Wood", 30, TechLevel.AGRICULTURE),
    //MEDIEVAL
    PAPER("Paper", 50, TechLevel.MEDIEVAL),
    TEA("Tea", 70, TechLevel.MEDIEVAL),
    MEDICINE("Medicine", 90, TechLevel.MEDIEVAL),
    GOLD("Gold", 100, TechLevel.MEDIEVAL),
    //RENAISSANCE
    PAINTING("Painting", 120, TechLevel.RENAISSANCE),
    BIBLE("Bible", 150, TechLevel.RENAISSANCE),
    POETRY("Poetry", 120, TechLevel.RENAISSANCE),
    //INDUSTRIAL
    COMPASS("Compass", 300, TechLevel.INDUSTRIAL),
    BOMB("Bomb", 400, TechLevel.INDUSTRIAL),
    WEAPON("Weapon", 500, TechLevel.INDUSTRIAL),
    //MODERN
    SMARTPHONE("Smart Phone", 800, TechLevel.MODERN),
    COMPUTERS("Computers", 1500, TechLevel.MODERN),
    PAD("Pad", 2500, TechLevel.MODERN),
    //FUTURISTIC
    DORAEMONn("Doraemon", 5000, TechLevel.FUTURISTIC),
    GLASSSCREEN("GlassScreen", 5000, TechLevel.FUTURISTIC);





    private String name;
    private int price;
    private TechLevel techlevel;

    private Item(String name, int price, TechLevel techlevel) {
        this.name = name;
        this.price = price;
        this.techlevel = techlevel;
    }


}
