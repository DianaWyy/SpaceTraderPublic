
public class Game {
    private String difficulity;
    private static String[] names = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    private Universe u;
    private Player p;

    public Game(String difficulty, String userName, int pilotSkill,
                int fighterSkill, int merchantSkill, int engineerSkill, int credits) {
        startGame(difficulty, userName, pilotSkill, fighterSkill,
                merchantSkill, engineerSkill, credits);


    }


    public void startGame(String difficulty, String name, int pilotSkill,
                          int fighterSkill, int merchantSkill, int engineerSkill, int credits) {
        this.difficulity = difficulty;
        // Creates Universe with list of names
        u = Universe.createUniverse(names);

        // Create Player Object with random location
        Region r = u.getRandomRegion();
        p = new Player(name, pilotSkill, fighterSkill, merchantSkill, engineerSkill, r, credits);

        // Create Map page
        new MapPage(u.getRegions(), p);
    }

}
