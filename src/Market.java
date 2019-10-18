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


    public void buy(Item item, Player player){
        if(player.getCredits() < item.getPrice()) {
            throw new IllegalArgumentException("Could not afford");
        }

        player.setCredits(player.getCredits() - item.getPrice());
    }

    /**
     * Should be affected based on the Player’s Merchant skill.
     * You should be able to explain and demonstrate the effect of the Player’s Merchant skill on prices.
     * Can start a new game with a different Merchant skill to demonstrate.
     * The effect should be noticeable.
     * Use a price calculator service here - you would need to create this.
     * In case of Python, an appropriate utility function would fulfill this requirement.
     * In case of Java Swing, an instance method for the Region class would fulfil this requirement.
     */






}
