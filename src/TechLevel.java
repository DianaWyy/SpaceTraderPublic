enum TechLevel {
    PRE_AG, AGRICULTURE, MEDIEVAL, RENAISSANCE, INDUSTRIAL, MODERN, FUTURISTIC;

    public static TechLevel getRandomTechLevel() {
        return values()[(int)(Math.random()*8)];
    }

}
