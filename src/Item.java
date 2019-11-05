import java.util.Random;

public enum Item {
   

    //PREAG
    STONE("Stone", 5, TechLevel.PREAG),
    PLANT("Plant", 7, TechLevel.PREAG),
    PUREWATER("Pure Water", 10, TechLevel.PREAG),
    LEAF("Leaf", 3, TechLevel.PREAG),
    EARTH("Earth", 1, TechLevel.PREAG),
    INSECT("Insect", 6, TechLevel.PREAG),
    FUNGI("Fungi", 2, TechLevel.PREAG),
    PREAGFUEL("Preag Fuel", 10, TechLevel.PREAG),
    PREAGTAPE("Preag Tape", 10, TechLevel.PREAG),
    STEAK("Steak", 15, TechLevel.PREAG),
    PORK("Pork", 12, TechLevel.PREAG),
    //AGRICULTURE
    RICE("Rice", 20, TechLevel.AGRICULTURE),
    FLOUR("Flour", 20, TechLevel.AGRICULTURE),
    WOOD("Wood", 30, TechLevel.AGRICULTURE),
    PLOW("Plow", 25, TechLevel.AGRICULTURE),
    SOYBEANS("Soybeans", 22, TechLevel.AGRICULTURE),
    CORN("Corn", 23, TechLevel.AGRICULTURE),
    EGG("Egg", 25, TechLevel.AGRICULTURE),
    HOGS("Hogs", 25, TechLevel.AGRICULTURE),
    TURKEYS("Turkeys", 27, TechLevel.AGRICULTURE),
    ARGFUEL("Agriculture Fuel", 30, TechLevel.AGRICULTURE),
    ARGTAPE("Agriculture Tape", 30, TechLevel.AGRICULTURE),
    //MEDIEVAL
    PAPER("Paper", 50, TechLevel.MEDIEVAL),
    TEA("Tea", 70, TechLevel.MEDIEVAL),
    MEDICINE("Medicine", 90, TechLevel.MEDIEVAL),
    GOLD("Gold", 100, TechLevel.MEDIEVAL),
    SILVER("Silver", 90, TechLevel.MEDIEVAL),
    MINE("Mine", 100, TechLevel.MEDIEVAL),
    PETROLEUM(" Petroleum", 110, TechLevel.MEDIEVAL),
    STEEL("Steel", 100, TechLevel.MEDIEVAL),
    MEDFUEL("Medieval Fuel", 120, TechLevel.MEDIEVAL),
    MEDTAPE("Medieval Tape", 120, TechLevel.MEDIEVAL),
    //RENAISSANCE
    PAINTING("Painting", 120, TechLevel.RENAISSANCE),
    BIBLE("Bible", 150, TechLevel.RENAISSANCE),
    POETRY("Poetry", 120, TechLevel.RENAISSANCE),
    BRUSH("Brush", 130, TechLevel.RENAISSANCE),
    HAMLET("Hamlet", 130, TechLevel.RENAISSANCE),
    MACBETH("Macbeth", 120, TechLevel.RENAISSANCE),
    RENFUEL("Renaissance Fuel", 200, TechLevel.RENAISSANCE),
    RENTAPE("Renaissance Tape", 200, TechLevel.RENAISSANCE),
    //INDUSTRIAL
    COMPASS("Compass", 300, TechLevel.INDUSTRIAL),
    BOMB("Bomb", 400, TechLevel.INDUSTRIAL),
    WEAPON("Weapon", 500, TechLevel.INDUSTRIAL),
    KNIFE("Knife", 450, TechLevel.INDUSTRIAL),
    SCREW("Screw", 500, TechLevel.INDUSTRIAL),
    WRENCH("Wrench", 550, TechLevel.INDUSTRIAL),
    OPENER("Opener", 420, TechLevel.INDUSTRIAL),
    STRING("String", 500, TechLevel.INDUSTRIAL),
    INDUSFUEL("Industrial Fuel", 600, TechLevel.INDUSTRIAL),
    INDUSTAPE("Industrial Tape", 600, TechLevel.INDUSTRIAL),
    //MODERN
    SMARTPHONE("Smart Phone", 800, TechLevel.MODERN),
    COMPUTERS("Computers", 1500, TechLevel.MODERN),
    PAD("Pad", 2500, TechLevel.MODERN),
    MP3("MP3", 2800, TechLevel.MODERN),
    PS4("PS4", 2900, TechLevel.MODERN),
    SWITCH("Switch", 1900, TechLevel.MODERN),
    CAMARA("Camera", 2900, TechLevel.MODERN),
    MICROPHONE("Microphone", 2900, TechLevel.MODERN),
    MODFUEL("Modern Fuel", 3000, TechLevel.MODERN),
    MODTAPE("Modern Tape", 3000, TechLevel.MODERN),
    //FUTURISTIC
    DORAEMON("Doraemon", 5000, TechLevel.FUTURISTIC),
    GLASSSCREEN("GlassScreen", 5000, TechLevel.FUTURISTIC),
    FUFUEL("Futuristic Fuel", 5000, TechLevel.FUTURISTIC),
    FUTAPE("Futuristic Tape", 5000, TechLevel.FUTURISTIC),
    SUPERMAN("Superman", 5500, TechLevel.FUTURISTIC),
    BATMAN("Batman", 6000, TechLevel.FUTURISTIC),
    IRONMAN("Ironman", 6000, TechLevel.FUTURISTIC),
    THOR("Thor", 7000, TechLevel.FUTURISTIC),
    THANOS("Thanos", 8000, TechLevel.FUTURISTIC),
    EXAM("Exam", 10000, TechLevel.FUTURISTIC);

    private String name;
    private int price;
    private TechLevel techlevel;

    private Item(String name, int price, TechLevel techlevel) {
        this.name = name;
        this.price = price;
        this.techlevel = techlevel;
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
        Item[] items = Item.values();

        int num = items.length;
        Random rand = new Random();

        return items[rand.nextInt(num)];
    }
}
