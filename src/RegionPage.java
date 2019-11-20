import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RegionPage extends JFrame {
    private Player p;
    private Ship ship;
    private Item selectedItem;
    private Item selectedCargo;
    private JLabel showCredits;
    private JLabel showCargoSpace;
    private JLabel welcome;
    private JLabel techLevel;
    private JComboBox buyDD;
    private JButton buy;
    private JLabel message;
    private JComboBox sellDD;
    private JButton sell;
    private JButton map;

    public RegionPage(Region r, Player p, MapPage mp) {
        this.p = p;
        ship = p.getShip();
        JFrame f = new JFrame("Region");
        Market market = new Market(r.getTechlevel(), p);
        if (r.isWinGame()) {
            Item i = Item.WINGAME;
            i.setName(String.format("%s's Universe", p.getUsername()));
            market.addItem(i);
        }
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        f.setSize(width, height);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setUndecorated(true); // full screen
        f.setVisible(true);
        f.getContentPane().setForeground(new Color(25, 25, 25));
        f.getContentPane().setBackground(new Color(25, 25, 25));
        f.setLayout(null);
        showCredits = new JLabel("Credits： " + p.getCredits());
        showCredits.setBounds(width - 300, 100, 400, 75);
        showCredits.setFont(new Font("Serif", Font.BOLD, 24));
        showCredits.setForeground(Color.white);
        f.add(showCredits);
        showCargoSpace = new JLabel(String.format("Cargo Space: %d/%d",
                ship.getCurrCargoSpace(), ship.getCargoSpace()));
        showCargoSpace.setBounds(width - 300, 150, 400, 75);
        showCargoSpace.setFont(new Font("Serif", Font.BOLD, 24));
        showCargoSpace.setForeground(Color.white);
        f.add(showCargoSpace);
        welcome = new JLabel(String.format("Welcome to Planet %s at (%d, %d)",
                r.getName(), r.getXCoordinate(), r.getYCoordinate()));
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcome.setBounds(width / 2 - 100, height / 6, 400, 50);
        welcome.setFont(new Font("Serif", Font.BOLD, 24));
        welcome.setForeground(Color.white);
        f.add(welcome);
        techLevel = new JLabel(String.format("This Region is in the %s Era",
                r.getTechlevel().getName()));
        techLevel.setAlignmentX(Component.CENTER_ALIGNMENT);
        techLevel.setBounds(width / 2 - 100, height / 6 + 50, 400, 50);
        techLevel.setFont(new Font("Serif", Font.BOLD, 24));
        techLevel.setForeground(Color.white);
        f.add(techLevel);
        message = new JLabel("");
        message.setBounds(width / 2 - 100, height / 6 + 150, 400, 50);
        message.setFont(new Font("Serif", Font.BOLD, 24));
        message.setForeground(Color.white);
        f.add(message);
        buyDD = new JComboBox(market.getItemNameList().toArray());
        buyDD.setSelectedIndex(0);
        selectedItem = market.getItemList().get(buyDD.getSelectedIndex());
        buyDD.addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            // Update Selection
                            selectedItem = market.getItemList().get(buyDD.getSelectedIndex());
                        }
                    }
                }
        );
        buyDD.setBounds(width / 2 - 100, height / 6 + 200, 250, 25);
        f.add(buyDD);
        buy = new JButton("Buy");
        buy.setFont(new Font("Serif", Font.BOLD, 20));
        buy.setBounds(width / 2 + 200, height / 6 + 200, 100, 40);
        f.add(buy);
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (p.getCredits() < selectedItem.getPrice()) {
                    message.setText("you are too pOoR");
                    return;
                }
                if (ship.getCurrCargoSpace() == p.getShip().getCargoSpace()) {
                    message.setText("your ship is too sMaLl");
                    return;
                }
                if (!Market.getNoNPC() && selectedItem.getName().toLowerCase().contains("fuel")) {
                    message.setText("You cannot refuel when encountering NPC.");
                }
                if (!Market.getNoNPC() && selectedItem.getName().toLowerCase().contains("duct tape")) {
                    message.setText("You cannot gain health when encountering NPC.");
                }
                market.buy(selectedItem);
                message.setText("Thanks for purchasing:)");
                showCredits.setText("Credits： " + p.getCredits());
                showCargoSpace.setText(String.format("Cargo Space: %d/%d",
                        ship.getCurrCargoSpace(), ship.getCargoSpace()));

                if (!selectedItem.getName().toLowerCase().contains("fuel")
                        && !selectedItem.getName().toLowerCase().contains("duct tape")) {
                    ship.addCargo(selectedItem);
                    sellDD.setModel(new DefaultComboBoxModel(ship.getCargoNameList().toArray()));
                    ItemEvent event = new ItemEvent(sellDD, 0, null, ItemEvent.SELECTED);
                    ItemListener l = sellDD.getItemListeners()[0];
                    l.itemStateChanged(event);
                }
            }
        });
        sellDD = new JComboBox(ship.getCargoNameList().toArray());
        if (ship.getCargoList().size() != 0) {
            sellDD.setSelectedIndex(0);
            selectedCargo = ship.getCargoList().get(sellDD.getSelectedIndex());
        }
        sellDD.addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            // Update Selection
                            selectedCargo = ship.getCargoList().get(sellDD.getSelectedIndex());
                        }
                    }
                }
        );
        sellDD.setBounds(width / 2 - 100, height / 6 + 300, 250, 25);
        f.add(sellDD);

        sell = new JButton("Sell");
        sell.setFont(new Font("Serif", Font.BOLD, 20));
        sell.setBounds(width / 2 + 200, height / 6 + 300, 100, 40);
        f.add(sell);
        sell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (ship.getCargoList().size() == 0) {
                    message.setText("you got nothin' boi");
                    return;
                }
                ship.removeCargo(selectedCargo);
                p.setCredits(p.getCredits() + selectedCargo.getPrice());
                message.setText("you got some $$$:)");
                showCredits.setText("Credits： " + p.getCredits());
                showCargoSpace.setText(String.format("Cargo Space: %d/%d",
                        ship.getCurrCargoSpace(), ship.getCargoSpace()));
                sellDD.setModel(new DefaultComboBoxModel(ship.getCargoNameList().toArray()));
                if (ship.getCargoList().size() != 0) {
                    sellDD.setSelectedIndex(0);
                    selectedCargo = ship.getCargoList().get(sellDD.getSelectedIndex());
                }
            }
        });
        map = new JButton("View Map"); //creating instance of JButton
        map.setAlignmentX(Component.CENTER_ALIGNMENT);
        map.setFont(new Font("Serif", Font.BOLD, 20));
        map.setBounds(width / 2, height / 4 + 400, 150, 40);
        f.add(map);
        map.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                f.dispose();
                mp.updateStats();
            }
        });
    }

}
