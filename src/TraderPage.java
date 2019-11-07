import javax.swing.*;
import java.awt.*;

public class TraderPage {
    private Player p;
    private Ship s;
    private int price;


    public TraderPage(Player p, Ship s, Region selected, double fuel, MapPage mp) {
        this.p = p;
        this.s = s;
        JFrame frame = new JFrame("Trader Encountered!");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width / 3, screenSize.height / 3);
        frame.setLayout(new BorderLayout());
        frame.setLocation(screenSize.width / 2 - frame.getWidth() / 2,
                screenSize.height / 2 - frame.getHeight() / 2);
        JPanel jp = new JPanel();
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        frame.setUndecorated(true); // full screen
        Item item = Item.getRandomItem();  // Gets Random Item
        int num = (int) (Math.random() * 5 + 1); // Number of said item
        price = item.getPrice() * num;
        Box b = new Box(BoxLayout.Y_AXIS);
        JLabel message = new JLabel("A trader has appeared! ");
        JLabel message2 = new JLabel(
                "He wants to sell you " + num + " " + item.getName() + ".");
        JLabel message3 = new JLabel("He demands a price of " + price);
        JLabel message4 = new JLabel();
        JLabel banditIcon = new JLabel(new ImageIcon("pic/trader.png"));
        JButton buy = new JButton("BUY");
        JButton ignore = new JButton("IGNORE");
        JButton rob = new JButton("ROB");
        JButton negotiate = new JButton("NEGOTIATE");
        JButton leave = new JButton("Keep Traveling..");
        b.add(message, BorderLayout.CENTER);
        b.add(message2, BorderLayout.CENTER);
        b.add(message3, BorderLayout.CENTER);
        b.add(message4, BorderLayout.CENTER);
        frame.add(banditIcon, BorderLayout.NORTH);
        frame.add(b, BorderLayout.CENTER);
        jp.add(buy);
        jp.add(ignore);
        jp.add(rob);
        jp.add(negotiate);
        if (p.getCredits() < price) {
            buy.setEnabled(false);
            message4.setText("However yOu ArE tOo PoOr >.<");
        }
        if (s.getCurrCargoSpace() + num > s.getCargoSpace()) {
            buy.setEnabled(false);
            rob.setEnabled(false);
            negotiate.setEnabled(false);
            message4.setText("You don't have enough space in your inventory!");
        }
        frame.add(jp, BorderLayout.SOUTH);
        frame.setBounds(300, 200, 600, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        buy.addActionListener(l -> {
            int beforeCredits = p.getCredits();
            p.setCredits(beforeCredits - price);
            int afterCredits = p.getCredits();
            for (int i = 0; i < num; i++) {
                s.addCargo(item);
            }
            message.setText("You bought the items!");
            message2.setText("The trader thanks you for your business!");
            message3.setText("Credits: " + beforeCredits + " -----> " + afterCredits);
            message4.setText("Items Acquired: " + item.getName() + " x" + num);
            frame.remove(jp);
            frame.add(leave, BorderLayout.SOUTH);
            p.setCurrentRegion(selected);
            s.decreaseCurrFuelCapacity(fuel);
        });
        ignore.addActionListener(l -> {
            message.setText("You decline the offer!");
            message2.setText("You decided to continue along your way!");
            message3.setText("");
            message4.setText("");
            frame.remove(jp);
            frame.add(leave, BorderLayout.SOUTH);
            p.setCurrentRegion(selected);
            s.decreaseCurrFuelCapacity(fuel);
        });
        rob.addActionListener(l -> {
            if (p.getFighterSkill() / 20.0 > Math.random()) {
                p.setCurrentRegion(selected);
                s.decreaseCurrFuelCapacity(fuel);
                for (int i = 0; i < num; i++) {
                    s.addCargo(item);
                }
                message.setText("You beat up the trader!");
                message2.setText("You acquired all of the trader's items!");
                message3.setText("Items Acquired: " + item.getName() + " x" + num);
                message4.setText("");
                frame.remove(jp);
                frame.add(leave, BorderLayout.SOUTH);
                p.setCurrentRegion(selected);
                s.decreaseCurrFuelCapacity(fuel);
            } else {
                int beforeHealth = s.getCurrHealth();
                s.setCurrHealth(Math.max(s.getCurrHealth() - 20, 0));
                int afterHealth = s.getCurrHealth();
                message.setText("The trader destroyed you! He got angry and hit your ship!");
                message2.setText("Health: " + beforeHealth + " -----> " + afterHealth);
                message3.setText("");
                message4.setText("");
                frame.remove(jp);
                frame.add(leave, BorderLayout.SOUTH);
                p.setCurrentRegion(selected);
                s.decreaseCurrFuelCapacity(fuel);
            }
        });
        negotiate.addActionListener(l -> {
            if (p.getMerchantSkill() / 20.0 > Math.random()) {
                price /= 2;
                message.setText("You successfully negotiated with the trader!");
                message2.setText("He wants to sell you " + num + " " + item.getName() + ".");
                message3.setText("His new price is " + price);
                message4.setText("");
                negotiate.setEnabled(false);
            } else {
                price *= 2;
                message.setText("Your bargaining skills were terrible and prices rose!");
                message2.setText(
                        "The Trader wants to sell you " + num + " " + item.getName() + ".");
                message3.setText("His new price is " + price);
                message4.setText("");
                negotiate.setEnabled(false);
            }
        });
        leave.addActionListener(l -> {
            frame.dispose();
//            MapPage bruh = new MapPage(mp.getRegions(), p, mp.getGame());
////            new RegionPage(p.getCurrentRegion(), p, bruh);
            mp.updateStats();
        });
    }
}