public class Game {
    private String difficulity;
    private int diffLevel;
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
        Region winGame = u.getRandomRegion();
        while (r.equals(winGame)) {
            winGame = u.getRandomRegion();
        }
        winGame.setWinGame();
        System.out.println("wingame: " + winGame.getName());
        p = new Player(name, pilotSkill, fighterSkill, merchantSkill, engineerSkill, r, credits);

        // changes difficulty into int
        switch (difficulty) {
        case "Easy":
            diffLevel = 1;
            break;
        case "Medium":
            diffLevel = 2;
            break;
        case "Hard":
            diffLevel = 3;
            break;
        default:
            diffLevel = 2;
            break;
        }

        // Create Map page
        new MapPage(u.getRegions(), p, this);
    }

    public int getDiffLevel() {
        return diffLevel;
    }

}