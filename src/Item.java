import java.util.Random;

public enum Item {

    //WINGAME
    WINGAME(null, 1000, null),

    //PREAG(5-20)
    PREAGFUEL("Preag Fuel", 5, TechLevel.PREAG),
    PREAGTAPE("Preag Duct Tape", 5, TechLevel.PREAG),
    STONE("Stone", 10, TechLevel.PREAG),
    PLANT("Plant", 17, TechLevel.PREAG),
    PUREWATER("Pure Water", 20, TechLevel.PREAG),
    LEAF("Leaf", 13, TechLevel.PREAG),
    EARTH("Earth", 11, TechLevel.PREAG),
    INSECT("Insect", 16, TechLevel.PREAG),
    FUNGI("Fungi", 12, TechLevel.PREAG),
    STEAK("Steak", 15, TechLevel.PREAG),
    PORK("Pork", 12, TechLevel.PREAG),

    //AGRICULTURE(20-50)
    ARGFUEL("Agriculture Fuel", 20, TechLevel.AGRICULTURE),
    ARGTAPE("Agriculture Duct Tape", 20, TechLevel.AGRICULTURE),
    RICE("Rice", 20, TechLevel.AGRICULTURE),
    FLOUR("Flour", 20, TechLevel.AGRICULTURE),
    WOOD("Wood", 30, TechLevel.AGRICULTURE),
    PLOW("Plow", 25, TechLevel.AGRICULTURE),
    SOYBEANS("Soybeans", 22, TechLevel.AGRICULTURE),
    CORN("Corn", 33, TechLevel.AGRICULTURE),
    EGG("Egg", 25, TechLevel.AGRICULTURE),
    HOGS("Hogs", 35, TechLevel.AGRICULTURE),
    TURKEYS("Turkeys", 50, TechLevel.AGRICULTURE),

    //MEDIEVAL(50-100)
    MEDFUEL("Medieval Fuel", 50, TechLevel.MEDIEVAL),
    MEDTAPE("Medieval Duct Tape", 50, TechLevel.MEDIEVAL),
    PAPER("Paper", 50, TechLevel.MEDIEVAL),
    TEA("Tea", 70, TechLevel.MEDIEVAL),
    MEDICINE("Medicine", 90, TechLevel.MEDIEVAL),
    GOLD("Gold", 90, TechLevel.MEDIEVAL),
    SILVER("Silver", 90, TechLevel.MEDIEVAL),
    MINE("Mine", 80, TechLevel.MEDIEVAL),
    PETROLEUM(" Petroleum", 100, TechLevel.MEDIEVAL),
    STEEL("Steel", 80, TechLevel.MEDIEVAL),

    //RENAISSANCE(100-300)
    RENFUEL("Renaissance Fuel", 100, TechLevel.RENAISSANCE),
    RENTAPE("Renaissance Duct Tape", 100, TechLevel.RENAISSANCE),
    PAINTING("Painting", 120, TechLevel.RENAISSANCE),
    BIBLE("Bible", 300, TechLevel.RENAISSANCE),
    POETRY("Poetry", 220, TechLevel.RENAISSANCE),
    BRUSH("Brush", 130, TechLevel.RENAISSANCE),
    HAMLET("Hamlet", 230, TechLevel.RENAISSANCE),
    MACBETH("Macbeth", 120, TechLevel.RENAISSANCE),

    //INDUSTRIAL(300-500)
    INDUSFUEL("Industrial Fuel", 300, TechLevel.INDUSTRIAL),
    INDUSTAPE("Industrial Duct Tape", 300, TechLevel.INDUSTRIAL),
    COMPASS("Compass", 370, TechLevel.INDUSTRIAL),
    BOMB("Bomb", 340, TechLevel.INDUSTRIAL),
    WEAPON("Weapon", 500, TechLevel.INDUSTRIAL),
    KNIFE("Knife", 345, TechLevel.INDUSTRIAL),
    SCREW("Screw", 450, TechLevel.INDUSTRIAL),
    WRENCH("Wrench", 455, TechLevel.INDUSTRIAL),
    OPENER("Opener", 345, TechLevel.INDUSTRIAL),
    STRING("String", 450, TechLevel.INDUSTRIAL),


    //MODERN (500-700)
    MODFUEL("Modern Fuel", 500, TechLevel.MODERN),
    MODTAPE("Modern Duct Tape", 500, TechLevel.MODERN),
    SMARTPHONE("Smart Phone", 500, TechLevel.MODERN),
    COMPUTERS("Computers", 550, TechLevel.MODERN),
    PAD("Pad", 550, TechLevel.MODERN),
    MP3("MP3", 580, TechLevel.MODERN),
    PS4("PS4", 590, TechLevel.MODERN),
    SWITCH("Switch", 600, TechLevel.MODERN),
    CAMARA("Camera", 640, TechLevel.MODERN),
    MICROPHONE("Microphone", 700, TechLevel.MODERN),

    //FUTURISTIC (700-1000)
    FUFUEL("Futuristic Fuel", 700, TechLevel.FUTURISTIC),
    FUTAPE("Futuristic Duct Tape", 700, TechLevel.FUTURISTIC),
    DORAEMON("Doraemon", 750, TechLevel.FUTURISTIC),
    GLASSSCREEN("GlassScreen", 700, TechLevel.FUTURISTIC),
    SUPERMAN("Superman", 760, TechLevel.FUTURISTIC),
    BATMAN("Batman", 750, TechLevel.FUTURISTIC),
    IRONMAN("Ironman", 780, TechLevel.FUTURISTIC),
    THOR("Thor", 850, TechLevel.FUTURISTIC),
    THANOS("Thanos", 900, TechLevel.FUTURISTIC),
    EXAM("Exam", 1000, TechLevel.FUTURISTIC);

    private String name;
    private int price;
    private TechLevel techlevel;

    Item(String name, int price, TechLevel techlevel) {
        this.name = name;
        this.price = price;
        this.techlevel = techlevel;
    }
    public Item getWinGameItem() {
        return WINGAME;
    }

    public TechLevel getTechlevel() {
        return techlevel;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTechlevel(TechLevel techlevel) {
        this.techlevel = techlevel;
    }

    public static Item getRandomItem() {
        Random rand = new Random();
        Item i;
        do {
            i = Item.values()[rand.nextInt(Item.values().length)];
        } while (i == WINGAME);
        return i;
    }
}