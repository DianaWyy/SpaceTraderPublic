import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class BanditPage extends JFrame {
    private Player p;
    private Ship s;


    public BanditPage(Player p, Ship s, Region selected, double fuel, MapPage mp, JComboBox regList) {
        this.p = p;
        this.s = s;
        Market.setNoNPC(false);
        JFrame frame = new JFrame("Bandit Encountered!");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width / 3, screenSize.height / 3);
        frame.setLayout(new BorderLayout());
        frame.setLocation(screenSize.width / 2 - frame.getWidth() / 2,
                screenSize.height / 2 - frame.getHeight() / 2);
        //        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //        frame.setUndecorated(true); // full screen
        JPanel jp = new JPanel();
        int demand = (int) (Math.random() * 900 + 100);  //Somewhere between 100 and 1000 credits
        Box b = new Box(BoxLayout.Y_AXIS);
        JLabel message = new JLabel("A wild bandit has appeared!"
                + "They demand a tribute of " + demand + " credits", JLabel.CENTER);
        JLabel message2 = new JLabel();
        JLabel message3 = new JLabel();
        JLabel message4 = new JLabel();
        JLabel banditIcon = new JLabel(new ImageIcon("pic/bandit.png"));
        JButton pay = new JButton("PAY");
        JButton flee = new JButton("FLEE");
        JButton fight = new JButton("FIGHT");
        JButton negotiate = new JButton("NEGOTIATE");
        JButton leave = new JButton("Keep Traveling..");
        b.add(message, BorderLayout.CENTER);
        b.add(message2, BorderLayout.CENTER);
        b.add(message3, BorderLayout.CENTER);
        b.add(message4, BorderLayout.CENTER);
        frame.add(banditIcon, BorderLayout.NORTH);
        frame.add(b, BorderLayout.CENTER);
        jp.add(pay);
        jp.add(flee);
        jp.add(fight);
        jp.add(negotiate);
        negotiate.setEnabled(false);
        frame.add(jp, BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        pay.addActionListener(l -> {
            if (p.getCredits() < demand) {
                if (s.getCargoList().size() == 0) {
                    int beforeHealth = s.getCurrHealth();
                    s.setCurrHealth(Math.max(s.getCurrHealth() - 20, 0));
                    int afterHealth = s.getCurrHealth();
                    int beforeCredits = p.getCredits();
                    p.setCredits(0);
                    message.setText("You don't have enough money or any cargo!");
                    message2.setText(
                            "The robbers took your credits and damaged your ship in anger!");
                    message3.setText("Credits: " + beforeCredits + " -----> " + 0);
                    message4.setText("Health: " + beforeHealth + " -----> " + afterHealth);
                    frame.remove(jp);
                    frame.add(leave, BorderLayout.SOUTH);
                    p.setCurrentRegion(selected);
                    s.decreaseCurrFuelCapacity(fuel);
                } else {
                    ArrayList<Item> cargo = s.getCargoList();
                    s.clearCargo();
                    int beforeCredits = p.getCredits();
                    p.setCredits(0);
                    message.setText(
                            "You don't have enough money! The robbers took all your inventory!");
                    message2.setText("Credits: " + beforeCredits + " -----> " + 0);
                    message3.setText("Items Lost: ");
                    String items = "";
                    for (Item item : cargo) {
                        items += item.getName() + ", ";
                    }
                    message4.setText(items);
                    frame.remove(jp);
                    frame.add(leave, BorderLayout.SOUTH);
                    p.setCurrentRegion(selected);
                    s.decreaseCurrFuelCapacity(fuel);
                }
            } else {
                int before = p.getCredits();
                p.setCredits(p.getCredits() - demand);
                int after = p.getCredits();
                message.setText("You chose to pay the bandit! GOSH DARN ROBBERS!!! ");
                message2.setText("Credits: " + before + " -----> " + after);
                frame.remove(jp);
                frame.add(leave, BorderLayout.SOUTH);
                p.setCurrentRegion(selected);
                s.decreaseCurrFuelCapacity(fuel);
            }
            Market.setNoNPC(true);
        });
        flee.addActionListener(l -> {
            if (p.getPilotSkill() / 20.0 > Math.random()) {
                s.decreaseCurrFuelCapacity(fuel);
                message.setText("You ran away! Not so lucky next time!");
                message2.setText(
                        "You decide to head back to region " + p.getCurrentRegion().getName());
                frame.remove(jp);
                frame.add(leave, BorderLayout.SOUTH);
            } else {
                s.decreaseCurrFuelCapacity(fuel);
                int beforeHealth = s.getCurrHealth();
                s.setCurrHealth(Math.max(s.getCurrHealth() - 30, 0));
                int afterHealth = s.getCurrHealth();
                int beforeCredits = p.getCredits();
                p.setCredits(0);
                message.setText(
                        "You failed to run away!"
                                + " The bandits took all your credits and hit your ship!");
                message2.setText("Credits: " + beforeCredits + " -----> " + 0);
                message3.setText("Health: " + beforeHealth + " -----> " + afterHealth);
                frame.remove(jp);
                frame.add(leave, BorderLayout.SOUTH);
            }
            Market.setNoNPC(true);
        });
        fight.addActionListener(l -> {
            if (p.getFighterSkill() / 20.0 > Math.random()) {
                p.setCurrentRegion(selected);
                s.decreaseCurrFuelCapacity(fuel);
                int reward = demand * 2;
                int beforeCredits = p.getCredits();
                p.setCredits(p.getCredits() + demand * 2);
                int afterCredits = p.getCredits();
                message.setText(
                        "You completely destroyed the bandits!"
                                + " You steal " + reward + " credits!");
                message2.setText("Credits: " + beforeCredits + " -----> " + afterCredits);
                frame.remove(jp);
                frame.add(leave, BorderLayout.SOUTH);
            } else {
                int beforeHealth = s.getCurrHealth();
                s.setCurrHealth(Math.max(s.getCurrHealth() - 30, 0));
                int afterHealth = s.getCurrHealth();
                int beforeCredits = p.getCredits();
                p.setCredits(0);
                message.setText(
                        "The bandits completely destroyed you!"
                                + " They took all your credits and hit your ship!");
                message2.setText("Credits: " + beforeCredits + " -----> " + 0);
                message3.setText("Health: " + beforeHealth + " -----> " + afterHealth);
                frame.remove(jp);
                frame.add(leave, BorderLayout.SOUTH);
            }
            Market.setNoNPC(true);
        });
        leave.addActionListener(l -> {
            frame.dispose();
            //            MapPage bruh = new MapPage(mp.getRegions(), p, mp.getGame());
            //            new RegionPage(p.getCurrentRegion(), p, bruh);
            mp.updateStats();
            ItemEvent event =
                    new ItemEvent(regList, 0, null, ItemEvent.SELECTED);
            ItemListener yeet = regList.getItemListeners()[0];
            yeet.itemStateChanged(event);
            Market.setNoNPC(true);
        });
    }
}