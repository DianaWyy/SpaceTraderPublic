import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.Toolkit;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;
import java.awt.event.*;

import javax.swing.*;
public class MainGame {
    public static Dimension screenSize;

    public static void main(String[] args) {

        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        JFrame f = new JFrame();//creating instance of JFrame


        JLabel l1;
        l1 = new JLabel("Space Trader");
        l1.setBounds(screenSize.width/2 - 225, screenSize.height/2 - 200, 500, 100);
        l1.setFont(new Font("Serif", Font.BOLD, 80));
        l1.setForeground(Color.white);

        f.add(l1);
        f.setSize(300, 300);

        JButton b = new JButton("Start Game");//creating instance of JButton
        b.setFont(new Font("Serif", Font.BOLD, 30));
        b.setBounds(screenSize.width/2 - 100, screenSize.height/2 - 50, 200, 65);

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