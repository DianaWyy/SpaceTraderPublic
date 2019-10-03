import java.util.ArrayList;

public class Universe {
    private ArrayList<Region> regions = new ArrayList<>();

    private static Universe onlyUniverse;

    public Universe(String[] regionNames){

        for(String regionName: regionNames) {
            regions.add(new Region((int)(Math.random()*401-200), (int)(Math.random()*401-200), regionName));
            // TODO
            // Make sure Regions are not too close
        }
    }

    public static Universe createUniverse(String[] regionNames) {
        if(onlyUniverse == null) {
            onlyUniverse = new Universe(regionNames);
        }
        return onlyUniverse;
    }

    public ArrayList<Region> getRegions() {
        return this.regions;
    }

    public Region getRandomRegion() {
        return regions.get((int) (Math.random() * regions.size()));
    }
}
