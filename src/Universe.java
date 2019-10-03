import java.util.ArrayList;

public class Universe {
    public static ArrayList<Region> allRegion = new ArrayList<>();
    public static int num;

    public Universe(int num){
        if (num <=9) {
            throw new IllegalArgumentException(
                    "10 Religion or more is required"
            );
        }
        for(int i = 0; i < 15; i++) {
            allRegion.add(new Region((int)(Math.random()*401-200), (int)(Math.random()*401-200), "region" + i));
        }
    }

    public static int getNum() {
        return num;
    }
}
