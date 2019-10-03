import java.util.ArrayList;

public class Game {
    private String difficulity;
    private static String[] names = {"A", "B", "C", "D", "E",
                                    "F", "G", "H", "I", "J"};
    private Universe u;

    public Game(String difficulty, String name, int pilotSkill, int fighterSkill, int merchantSkill,
                int engineerSkill, int credits) {
        startGame(difficulty, name, pilotSkill, fighterSkill, merchantSkill, engineerSkill, credits);

        // Create Map page
    }


    public void startGame(String difficulty, String name, int pilotSkill, int fighterSkill, int merchantSkill,
                          int engineerSkill, int credits){
        this.difficulity = difficulty;
        // Creates Universe with list of names
        Universe u = Universe.createUniverse(names);

        // Create Money and Allocate money to player
        Region r = u.getRandomRegion();
        Player myPlayer = new Player(name, pilotSkill, fighterSkill, merchantSkill, engineerSkill, r, credits );

    }

}
