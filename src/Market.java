import java.util.ArrayList;
import java.util.Random;

public class Market {
    private Item[] allItems = Item.values();
    private ArrayList<Item> effectiveItems = new ArrayList<>();
    private TechLevel techLevel;
    private Player p;
    private static boolean noNPC = true;

    private static Random r = new Random();

    public Market(TechLevel techLevel, Player p) {
        this.p = p;
        for (int i = 0; i < allItems.length; i++) {
            Item item = allItems[i];
            if (item.getTechlevel() == techLevel) {

                // Sets Price Fluctuation between 0.8 and 1.2
                double priceFlux = r.nextDouble() * (0.4) + 0.8;

                // Having Merchant Skill influences price flux in range of 0 - 0.2
                priceFlux -= p.getMerchantSkill() / 100.0;

                int newPrice = (int) (item.getPrice() * priceFlux);
                item.setPrice(newPrice);
                effectiveItems.add(item);
            }
        }
    }

    public ArrayList<Item> getItemList() {
        return effectiveItems;
    }

    public ArrayList<String> getItemNameList() {
        ArrayList<String> nameList = new ArrayList<>();
        for (Item i : effectiveItems) {
            nameList.add(String.format("$%d %s", i.getPrice(), i.getName()));
        }
        return nameList;
    }

    public void buy(Item item) {
        if (item.getName().toLowerCase().contains("fuel") && noNPC) {
            refuel(this.p.getShip());
        } else if (item.getName().toLowerCase().contains("health") && noNPC) {
            gainHealth(this.p.getShip(), item);
        }
        p.setCredits(p.getCredits() - item.getPrice());
    }
    private void refuel(Ship ship) {
        ship.setCurrFuelCapacity(ship.getFuelCapacity());
    }
    private void gainHealth(Ship ship, Item item) {
        int price = (int) (item.getPrice() * (1 - p.getEngineerSkill() * 0.05));
        item.setPrice(price);
        ship.setCurrHealth(ship.getHealth());
    }
    public static boolean getNoNPC() {
        return noNPC;
    }
    public static void setNoNPC(boolean bool) {
        noNPC = bool;
    }
}
