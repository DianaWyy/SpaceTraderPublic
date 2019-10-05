import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MapPage extends JFrame {
    private Region selected;
    public MapPage(ArrayList<Region> regions, Player p) {
        JFrame f = new JFrame("Map");
        ArrayList<String> regNames = new ArrayList<>();

        // get width and height of screen
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

//        BufferedImage bf = ImageIO.read(new File("pic/loginpic.jpg"));
//         adding created component to the JFrame using my backImage class
//        f.setContentPane(new backImage(bf));


//        Add all regions to the Map

        for (Region reg : regions) {
            String spec = String.format("%s %s: (%d, %d)",reg.getName(), reg.getTechlevel().getName(), reg.getXCoordinate(), reg.getYCoordinate());
            regNames.add(spec);
            if (reg.equals(p.getCurrentRegion())) {
                JLabel star = new JLabel("(-。-)", SwingConstants.CENTER);
                star.setBounds(width / 2 + reg.getXCoordinate(), height / 2 - reg.getYCoordinate(), 50, 25);
                star.setFont(new Font("Serif", Font.BOLD, 20));
                star.setForeground(Color.white);
                f.add(star);
            } else {
                JLabel star = new JLabel("*", SwingConstants.CENTER);
                star.setBounds(width / 2 + reg.getXCoordinate(), height / 2 - reg.getYCoordinate(), 50, 25);
                star.setFont(new Font("Serif", Font.BOLD, 20));
                star.setForeground(Color.white);
                f.add(star);
            }

            JLabel starName = new JLabel(reg.getName(), SwingConstants.CENTER);
            starName.setBounds(width / 2 + reg.getXCoordinate(), height / 2 - reg.getYCoordinate() + 5, 50, 50);
            starName.setFont(new Font("Serif", Font.BOLD, 20));
            starName.setForeground(Color.white);
            f.add(starName);
        }

//        Add credits

        JLabel showCredits = new JLabel("Credits： " + p.getCredits());
        showCredits.setBounds(width - 300, 100, 400, 75);
        showCredits.setFont(new Font("Serif", Font.BOLD, 24));
        showCredits.setForeground(Color.white);
        f.add(showCredits);

//        Add Drop-down list

        selected = regions.get(0);
        JComboBox regList = new JComboBox(regNames.toArray());
        regList.setSelectedIndex(0);
        regList.addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            selected = regions.get(regList.getSelectedIndex());
                        }
                    }
                }
        );
        regList.setBounds(width / 2 - 200, 125, 250, 25);
        f.add(regList);


        JButton travel = new JButton("Travel");
        travel.setFont(new Font("Serif", Font.BOLD, 20));
        travel.setBounds(width / 2 + 100, 125, 100, 40);
        f.add(travel);

        travel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new RegionPage(selected, p);
                
            }
        });





    }


}
