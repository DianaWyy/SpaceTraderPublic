import java.util.ArrayList;

public class Market {
    public Item[] allItems = Item.values();
    ArrayList<Item> effectiveItems = new ArrayList<>();
    TechLevel techLevel;

    public Market(TechLevel techLevel) {
        for(int i = 0; i < allItems.length; i++) {
            if (allItems[i].getTechlevel() == techLevel) {
                effectiveItems.add(allItems[i]);
            }
        }
    }


    public void buy(Item item, Player player, Region region){
        int newPrice = region.priceCalculator(item);
        newPrice = (int) (newPrice - player.getMerchantSkill() * 0.25);
        if(player.getCredits() < newPrice) {
            throw new IllegalArgumentException("Could not afford");
        }

        player.setCredits(player.getCredits() - newPrice);
    }
}
