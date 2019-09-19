import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Image;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;
public class MainGame {
    public static void main(String[] args) {
        JFrame f=new JFrame();//creating instance of JFrame



        JLabel l1;
        l1=new JLabel("Space Trader");
        l1.setBounds(130,100, 400,100);
        l1.setFont( new Font("Serif",Font.BOLD, 48));
        l1.setForeground(Color.white);

        f.add(l1);
        f.setSize(300,300);

        JButton b=new JButton("Start Game");//creating instance of JButton
        b.setBounds(130,200,100, 40);//x axis, y axis, width, height

        f.add(b);//adding button in JFrame








        f.setSize(900,500);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
        f.getContentPane().setForeground(new Color(25, 25, 25));
        f.getContentPane().setBackground(new Color(25, 25, 25));







        class ExImage extends JPanel {

            public ExImage() {
                ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("download.jpeg"));
                JLabel label = new JLabel(imageIcon);
                add(label);
            }
        }



        }

}  