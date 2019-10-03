import java.util.ArrayList;

public class Game {
    private String difficulity;
    private ArrayList<String> names;


    public void startGame(String difficulty, String name, int pilotSkill, int fighterSkill, int merchantSkill,
                          int engineerSkill){
        this.difficulity = difficulty;
        for(Region r: Universe.allRegion) {
            names.add(r.getName());
        }
        Universe theOnly = new Universe(Universe.getNum());
        Player myPlayer = new Player(name, pilotSkill, fighterSkill, merchantSkill, engineerSkill);



    }

}
