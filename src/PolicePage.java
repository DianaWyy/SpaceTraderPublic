import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collections;

public class PolicePage {
    private Player p;
    private Ship s;

    private String stolenList = "";


    public PolicePage(Player p, Ship s, Region selected,
                      double fuel, MapPage mp, int numCargo, JComboBox regList) {
        this.p = p;
        this.s = s;
        Market.setNoNPC(false);
        Item[] stolen = new Item[numCargo];
        Collections.shuffle(s.getCargoList());
        for (int i = 0; i < numCargo; i++) {
            stolen[i] = s.getCargoList().get(i);
            stolenList += stolen[i] + ", ";
        }
        JFrame frame = new JFrame("Police Encountered!");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width / 3, screenSize.height / 3);
        frame.setLocation(screenSize.width / 2 - frame.getWidth() / 2,
                screenSize.height / 2 - frame.getHeight() / 2);
        //        frame.setSize(1280, 720);
        frame.setLayout(new BorderLayout());
        JPanel jp = new JPanel();
        //        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //        frame.setUndecorated(true); // full screen
        Box b = new Box(BoxLayout.Y_AXIS);
        JLabel message = new JLabel("A police squadron has appeared!");
        JLabel message2 = new JLabel("The chief demands you hand over some stolen goods");
        JLabel message3 = new JLabel("The following goods are marked as stolen: ");
        JLabel message4 = new JLabel(stolenList);
        JLabel banditIcon = new JLabel(new ImageIcon("pic/police.jpg"));
        JButton forfeit = new JButton("FORFEIT");
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
        jp.add(forfeit);
        jp.add(flee);
        jp.add(fight);
        jp.add(negotiate);
        negotiate.setEnabled(false);
        frame.add(jp, BorderLayout.SOUTH);
        frame.setBounds(300, 200, 600, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        forfeit.addActionListener(l -> {
            for (Item i : stolen) {
                s.getCargoList().remove(i);
            }
            message.setText("The POPO thank you for your cooperation!");
            message2.setText("The following items have been confiscated!");
            message3.setText(stolenList);
            message4.setText("");
            frame.remove(jp);
            frame.add(leave, BorderLayout.SOUTH);
            p.setCurrentRegion(selected);
            s.decreaseCurrFuelCapacity(fuel);
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
                s.setCurrHealth(Math.max(s.getCurrHealth() - 20, 0));
                int afterHealth = s.getCurrHealth();
                int beforeCredits = p.getCredits();
                p.setCredits(beforeCredits / 2);
                int afterCredits = p.getCredits();
                for (Item i : stolen) {
                    s.getCargoList().remove(i);
                }
                message.setText(
                        "You failed to run away!"
                                + " The police fined you half of your credits and hit your ship!");
                message2.setText("Credits: " + beforeCredits + " -----> " + afterCredits);
                message3.setText("Health: " + beforeHealth + " -----> " + afterHealth);
                message4.setText("The following items have been confiscated: " + stolenList);
                frame.remove(jp);
                frame.add(leave, BorderLayout.SOUTH);
            }
            Market.setNoNPC(true);
        });
        fight.addActionListener(l -> {
            if (p.getFighterSkill() / 20.0 > Math.random()) {
                p.setCurrentRegion(selected);
                s.decreaseCurrFuelCapacity(fuel);
                message.setText("You completely destroyed the POPO!");
                message2.setText("You decide to continue along your way.");
                message3.setText("");
                message4.setText("");
                frame.remove(jp);
                frame.add(leave, BorderLayout.SOUTH);
            } else {
                p.setCurrentRegion(selected);
                s.decreaseCurrFuelCapacity(fuel);
                int beforeHealth = s.getCurrHealth();
                s.setCurrHealth(Math.max(s.getCurrHealth() - 20, 0));
                int afterHealth = s.getCurrHealth();
                int beforeCredits = p.getCredits();
                p.setCredits(beforeCredits / 2);
                int afterCredits = p.getCredits();
                for (Item i : stolen) {
                    s.getCargoList().remove(i);
                }
                message.setText(
                        "You failed to beat the POPO!"
                                + " The police fined you half of your credits and hit your ship!");
                message2.setText("Credits: " + beforeCredits + " -----> " + afterCredits);
                message3.setText("Health: " + beforeHealth + " -----> " + afterHealth);
                message4.setText("The following items have been confiscated: " + stolenList);
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