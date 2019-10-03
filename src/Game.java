import java.util.ArrayList;

public class Game {
    public String difficulity;
    public ArrayList<String> names;


    public void startGame(){
        difficulity = LoginPage.difficulty;
        for(Region r: Universe.allRegion) {
            names.add(r.getName());
        }
        Universe theOnly = new Universe(Universe.getNum());
        Player myPlayer = new Player();



    }



}
