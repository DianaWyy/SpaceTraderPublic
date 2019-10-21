import java.util.ArrayList;

public class Market {
    private Item[] allItems = Item.values();
    private ArrayList<Item> effectiveItems = new ArrayList<>();
    private TechLevel techLevel;
    private Player p;

    public Market(TechLevel techLevel, Player p) {
        this.p = p;
        for (int i = 0; i < allItems.length; i++) {
            Item item = allItems[i];
            if (item.getTechlevel() == techLevel) {
                int newPrice = (int) (item.getPrice() * techLevel.getLevel() * 0.25
                        - p.getMerchantSkill() * 0.25);
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
        for (Item i: effectiveItems) {
            nameList.add(String.format("$%d %s", i.getPrice(), i.getName()));
        }
        return nameList;
    }

    public void buy(Item item) {

    }
}
