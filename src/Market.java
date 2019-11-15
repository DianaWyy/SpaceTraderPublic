import java.util.ArrayList;
import java.util.Random;

public class Market {
    private Item[] allItems = Item.values();
    private ArrayList<Item> effectiveItems = new ArrayList<>();
    private TechLevel techLevel;
    private Player p;

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

    }

    public void refuel(Ship ship) {
        int price = effectiveItems.get(0).getPrice();
        p.setCredits(p.getCredits() - price);
    }
}
