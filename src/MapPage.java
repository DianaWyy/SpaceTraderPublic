import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MapPage extends JFrame {
    private Region selected;
    private Region currRegion;
    private Map<Region, JLabel> stars;
    private int width;
    private int height;

    private double distance;
    private double fuel;

    private JFrame f;
    private Player p;
    private Ship s;

    //getter setters for regions and games
    public ArrayList<Region> getRegions() {
        return regions;
    }

    public Game getGame() {
        return game;
    }

    private ArrayList<Region> regions;
    private Game game;

    // instance Variables representing Labels

    private JLabel shipType;
    private JLabel shipSpace;
    private JLabel shipFuel;
    private JLabel shipHealth;
    private JLabel showCredits;
    private JLabel currLocation;
    private JLabel currTech;
    private JLabel currCoords;

    private JLabel warning;
    private MapPage mp = this;
    private JButton travel;
    private JButton shipFact;

    public MapPage(ArrayList<Region> regions, Player p, Game g) {
        this.regions = regions;
        this.game = g;
        f = new JFrame("Map");
        this.p = p;
        s = p.getShip();
        ArrayList<String> regNames = new ArrayList<>();
        stars = new HashMap<>();
        currRegion = p.getCurrentRegion();
        RegionPage currRegPage;

        // get width and height of screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.width;
        height = screenSize.height;

        f.setSize(width, height);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setUndecorated(true); // full screen
        f.setVisible(true);
        f.getContentPane().setForeground(new Color(25, 25, 25));
        f.getContentPane().setBackground(new Color(25, 25, 25));
        f.setLayout(null);

        //BufferedImage bf = ImageIO.read(new File("pic/loginpic.jpg"));
        //adding created component to the JFrame using my backImage class
        //f.setContentPane(new backImage(bf));

        //Add Stats to the page
        displayStats(f, p);

        //Add all regions to the Map
        for (Region reg : regions) {
            String spec = String.format("%s %s: (%d, %d)", reg.getName(),
                    reg.getTechlevel().getName(), reg.getXCoordinate(), reg.getYCoordinate());
            regNames.add(spec);

            JLabel star = new JLabel("*", SwingConstants.CENTER);
            star.setBounds(width / 2 + reg.getXCoordinate(),
                    height / 2 - reg.getYCoordinate(), 50, 25);
            star.setFont(new Font("Serif", Font.BOLD, 20));
            if (reg == currRegion) {
                star.setForeground(Color.red);
            } else {
                star.setForeground(Color.white);
            }

            f.add(star);
            stars.put(reg, star);

            JLabel starName = new JLabel(reg.getName(), SwingConstants.CENTER);
            starName.setBounds(width / 2 + reg.getXCoordinate(),
                    height / 2 - reg.getYCoordinate() + 5, 50, 50);
            starName.setFont(new Font("Serif", Font.BOLD, 20));
            starName.setForeground(Color.white);
            f.add(starName);
        }

        // Distance and Fuel Cost

        selected = regions.get(0);
        distance = selected.computeDistance(currRegion);

        fuel = p.calcTravelCost(distance);

        JLabel travelCost = new JLabel(String.format(
                "Distance: %.2f  Fuel Cost: %.2f", distance, fuel));
        travelCost.setBounds(width / 2 - 200, 175, 400, 25);
        travelCost.setFont(new Font("Serif", Font.BOLD, 20));
        travelCost.setForeground(Color.white);
        f.add(travelCost);

        //Add Drop-down list

        JComboBox regList = new JComboBox(regNames.toArray());
        regList.setSelectedIndex(0);
        regList.addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            // Update Selection
                            selected = regions.get(regList.getSelectedIndex());
                            distance = selected.computeDistance(currRegion);

                            fuel = p.calcTravelCost(distance);

                            travelCost.setText(String.format(
                                    "Distance: %.2f  Fuel Cost: %.2f", distance, fuel));

                        }
                    }
                }
        );
        regList.setBounds(width / 2 - 200, 125, 250, 25);
        f.add(regList);


        travel = new JButton("Travel");
        travel.setFont(new Font("Serif", Font.BOLD, 20));
        travel.setBounds(width / 2 + 100, 125, 100, 40);
        f.add(travel);

        warning = new JLabel("");
        warning.setBounds(width / 2 - 200, 225, 400, 25);
        warning.setFont(new Font("Serif", Font.BOLD, 24));
        warning.setForeground(Color.white);
        f.add(warning);

        travel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                double currFuel = s.getCurrFuelCapacity();

                if (fuel > currFuel) {
                    warning.setText("You don't have enough fuel!");
                    f.repaint();

                } else {
                    if (selected != p.getCurrentRegion() && g.getDiffLevel()*Math.random() > 0.5) { // bandit encounter
                        double trash = Math.random();

                        if (trash < 0.33) {
                            //pops up bandit encounter page
                            //BannditPage creates new MapPage and new RegionPage, original MapPage is disposed
                            new BanditPage(p, s, selected, fuel, mp);
                        } else if (trash > 0.66) {
                            new TraderPage(p, s, selected, fuel, mp);
                        } else {
                            int numItems = s.getCurrCargoSpace();
                            Random rand = new Random();
                            if(numItems == 0) {
                                p.setCurrentRegion(selected);
                                s.decreaseCurrFuelCapacity(fuel);
                                warning.setText("");

                                new RegionPage(selected, p, mp);

                                updateStats();
                                ItemEvent event = new ItemEvent(regList, 0, null, ItemEvent.SELECTED);
                                ItemListener l = regList.getItemListeners()[0];
                                l.itemStateChanged(event);

                                f.repaint();
                            } else {

                                int selectedItem = rand.nextInt(numItems);

                                if (selectedItem != 0) {
                                    new PolicePage(p, s, selected, fuel, mp, selectedItem);
                                } else { // Continue along way
                                    p.setCurrentRegion(selected);
                                    s.decreaseCurrFuelCapacity(fuel);
                                    warning.setText("");

                                    new RegionPage(selected, p, mp);

                                    updateStats();
                                    ItemEvent event = new ItemEvent(regList, 0, null, ItemEvent.SELECTED);
                                    ItemListener l = regList.getItemListeners()[0];
                                    l.itemStateChanged(event);

                                    f.repaint();
                                }
                            }

                        }

                    } else { //no encounter
                        p.setCurrentRegion(selected);
                        s.decreaseCurrFuelCapacity(fuel);
                        warning.setText("");

                        new RegionPage(selected, p, mp);

                        updateStats();
                        ItemEvent event = new ItemEvent(regList, 0, null, ItemEvent.SELECTED);
                        ItemListener l = regList.getItemListeners()[0];
                        l.itemStateChanged(event);

                        f.repaint();
                    }
                }
            }
        });

        shipFact = new JButton("Ship Factory");
        shipFact.setFont(new Font("Serif", Font.BOLD, 20));
        shipFact.setBounds(width - 300, 175, 200, 40);
        f.add(shipFact);

        shipFact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new ShipFactoryPage(p, mp);
            }
        });

    }

    public void displayStats(JFrame f, Player p) {

        // Add the ship and stats to the Map

        JLabel shipStats = new JLabel("Ship Stats:");
        shipStats.setBounds(200, 125, 400, 25);
        shipStats.setFont(new Font("Serif", Font.BOLD, 24));
        shipStats.setForeground(Color.white);
        f.add(shipStats);

        shipType = new JLabel("Type: " + s.getType());
        shipType.setBounds(250, 175, 400, 25);
        shipType.setFont(new Font("Serif", Font.BOLD, 24));
        shipType.setForeground(Color.white);
        f.add(shipType);

        shipSpace = new JLabel("Cargo Space: " + s.getCurrCargoSpace() + "/" + s.getCargoSpace());
        shipSpace.setBounds(250, 225, 400, 25);
        shipSpace.setFont(new Font("Serif", Font.BOLD, 24));
        shipSpace.setForeground(Color.white);
        f.add(shipSpace);

        shipFuel = new JLabel("Fuel: " + s.getCurrFuelCapacity() + "/" + s.getFuelCapacity());
        shipFuel.setBounds(250, 275, 400, 25);
        shipFuel.setFont(new Font("Serif", Font.BOLD, 24));
        shipFuel.setForeground(Color.white);
        f.add(shipFuel);

        shipHealth = new JLabel("Health: " + s.getCurrHealth() + "/" + s.getHealth());
        shipHealth.setBounds(250, 325, 400, 25);
        shipHealth.setFont(new Font("Serif", Font.BOLD, 24));
        shipHealth.setForeground(Color.white);
        f.add(shipHealth);

        //Add credits

        showCredits = new JLabel("Credits： " + p.getCredits());
        showCredits.setBounds(width - 300, 100, 400, 75);
        showCredits.setFont(new Font("Serif", Font.BOLD, 24));
        showCredits.setForeground(Color.white);
        f.add(showCredits);

        // Display Current Location

        currLocation = new JLabel("Current Location： " + this.currRegion.getName());
        currLocation.setBounds(200, 400, 400, 25);
        currLocation.setFont(new Font("Serif", Font.BOLD, 24));
        currLocation.setForeground(Color.white);
        f.add(currLocation);

        currTech = new JLabel("Tech Level: " + currRegion.getTechlevel().getName());
        currTech.setBounds(225, 450, 400, 25);
        currTech.setFont(new Font("Serif", Font.BOLD, 24));
        currTech.setForeground(Color.white);
        f.add(currTech);

        currCoords = new JLabel("Coordinates: (" + currRegion.getXCoordinate()
                + ", " + currRegion.getYCoordinate() + ")");
        currCoords.setBounds(225, 500, 400, 25);
        currCoords.setFont(new Font("Serif", Font.BOLD, 24));
        currCoords.setForeground(Color.white);
        f.add(currCoords);

    }

    public void updateStats() {
        shipType.setText("Type: " + s.getType());
        shipSpace.setText("Cargo Space: " + s.getCurrCargoSpace() + "/" + s.getCargoSpace());
        shipFuel.setText(String.format("Fuel: %.2f/ %.2f",
                s.getCurrFuelCapacity(), s.getFuelCapacity()));
        shipHealth.setText("Health: " + s.getCurrHealth() + "/" + s.getHealth());

        showCredits.setText("Credits： " + p.getCredits());

        currRegion = p.getCurrentRegion();

        currLocation.setText("Current Location： " + currRegion.getName());
        currTech.setText("Tech Level: " + currRegion.getTechlevel().getName());
        currCoords.setText("Coordinates: (" + currRegion.getXCoordinate()
                + ", " + currRegion.getYCoordinate() + ")");

        // Update red planet
        for (Region reg: stars.keySet()) {
            JLabel star = stars.get(reg);
            if (star.getForeground() == Color.red) {
                star.setForeground(Color.white);
            }

            if (reg == currRegion) {
                star.setForeground(Color.red);
            }
        }

        showCredits.setText("Credits： " + p.getCredits());

    }


}
