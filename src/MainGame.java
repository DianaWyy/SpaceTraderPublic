import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


import javax.swing.*;
import java.awt.event.*;

import javax.swing.*;
public class MainGame {

    public static void main(String[] args) {

        JFrame f = new JFrame();//creating instance of JFrame
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        JLabel l1;
        l1 = new JLabel("Space Trader");
        l1.setBounds(width/2 - 225, height/2 - 200, 500, 100);
        l1.setFont(new Font("Serif", Font.BOLD, 80));
        l1.setForeground(Color.white);

        f.add(l1);
        f.setSize(300, 300);

        JButton b = new JButton("Start Game");//creating instance of JButton
        b.setFont(new Font("Serif", Font.BOLD, 30));
        b.setBounds(width/2 - 100, height/2 - 50, 200, 65);

        f.add(b);


        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new LoginPage();
                f.dispose();
            }
        });

        // full screen
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setUndecorated(true);

        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
        f.getContentPane().setForeground(new Color(25, 25, 25));
        f.getContentPane().setBackground(new Color(25, 25, 25));







        /*class ExImage extends JPanel {

            public ExImage() {
                ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("download.jpeg"));
                JLabel label = new JLabel(imageIcon);
                add(label);
            }
        }*/


    }

}  