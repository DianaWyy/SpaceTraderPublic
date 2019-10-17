import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Universe {
    private ArrayList<Region> regions = new ArrayList<>();

    private static Universe onlyUniverse;

    public Universe(String[] regionNames) {

        // Pull up list of potential Images
        File picDirect = new File("pic/Planets");
        File[] pics = picDirect.listFiles();
        int i = 0;

        for (String regionName: regionNames) {

            BufferedImage image = null;
            // Assign picture to region on map
            try {
                image = ImageIO.read(pics[i]);
                i++;
                if(i == pics.length ) {
                    i = 0;
                }

            } catch (IOException e) {
                System.out.println("Picture was missing!");
            }

            int x = (int) (Math.random() * 401 - 200);
            int y = (int) (Math.random() * 401 - 200);
            Region newRegion = new Region(x, y, regionName, image);

            while (compareTooClose(newRegion)) {
                x = (int) (Math.random() * 401 - 200);
                y = (int) (Math.random() * 401 - 200);
                newRegion = new Region(x, y, regionName, image);
            }



            regions.add(newRegion);

        }
    }

    private boolean compareTooClose(Region newRegion) {
        for (Region r: regions) {
            if (newRegion.tooClose(r)) {
                return true;
            }
        }
        return false;
    }

    public static Universe createUniverse(String[] regionNames) {
        if (onlyUniverse == null) {
            onlyUniverse = new Universe(regionNames);
        }
        return onlyUniverse;
    }

    public ArrayList<Region> getRegions() {
        return this.regions;
    }

    public Region getRandomRegion() {
        return regions.get((int) (Math.random() * (regions.size())));
    }
}
