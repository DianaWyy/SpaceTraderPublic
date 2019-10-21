import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ShipFactoryPage extends JFrame {
    private Player p;
    private Ship ship;
    private Ship selectedShip;
    private JLabel welcome;
    private JLabel showCredits;
    private JComboBox shipDD;
    private JButton map;


    public ShipFactoryPage(Player p, MapPage mp) {
        this.p = p;
        ship = p.getShip();
        JFrame f = new JFrame("Ship Factory");
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


        welcome = new JLabel(String.format("Welcome to the Ship Factory, %s!", p.getUsername()));
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcome.setBounds(width / 2 - 100, height / 6, 400, 50);
        welcome.setFont(new Font("Serif", Font.BOLD, 24));
        welcome.setForeground(Color.white);
        f.add(welcome);

        shipDD = new JComboBox(ship.getShipNameList().toArray());
        shipDD.setSelectedIndex(0);
        selectedShip = ship.getShipList().get(0);
        shipDD.addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            // Update Selection
                            selectedShip = ship.getShipList().get(shipDD.getSelectedIndex());
                        }
                    }
                }
        );
        shipDD.setBounds(width / 2 - 100, height / 6 + 200, 500, 25);
        f.add(shipDD);


        showCredits = new JLabel("Credits： " + p.getCredits());
        showCredits.setBounds(width - 300, 100, 400, 75);
        showCredits.setFont(new Font("Serif", Font.BOLD, 24));
        showCredits.setForeground(Color.white);
        f.add(showCredits);


        // Add View Map Button
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
