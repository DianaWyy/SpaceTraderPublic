import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegionPage extends JFrame {
    public RegionPage(Region r, Player p) {
        JFrame f = new JFrame("Region");

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

        JLabel name = new JLabel(r.getName());
        name.setAlignmentX(Component.CENTER_ALIGNMENT);
        name.setBounds(width / 2, height / 4, 400, 50);
        name.setFont(new Font("Serif", Font.BOLD, 24));
        name.setForeground(Color.white);
        f.add(name);

        JLabel techLevel = new JLabel(r.getTechlevel().getName());
        techLevel.setAlignmentX(Component.CENTER_ALIGNMENT);
        techLevel.setBounds(width / 2, height / 4 + 50, 400, 50);
        techLevel.setFont(new Font("Serif", Font.BOLD, 24));
        techLevel.setForeground(Color.white);
        f.add(techLevel);

        JLabel coord = new JLabel(String.format("(%d, %d)", r.getXCoordinate(), r.getYCoordinate()));
        coord.setAlignmentX(Component.CENTER_ALIGNMENT);
        coord.setBounds(width / 2, height / 4 + 100, 400, 50);
        coord.setFont(new Font("Serif", Font.BOLD, 24));
        coord.setForeground(Color.white);
        f.add(coord);

        // Add Confirm Button
        JButton back = new JButton("Back");//creating instance of JButton
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        back.setFont(new Font("Serif", Font.BOLD, 20));
        back.setBounds(width / 2, height / 4 + 400, 100, 50);
        f.add(back);

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                f.dispose();
            }
        });
    }
}
