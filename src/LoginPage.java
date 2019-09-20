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
import java.awt.event.*;

import javax.swing.*;

public class LoginPage {
    private JFrame f = new JFrame("Second");
    public static String name;


    public LoginPage() {

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(900, 500);
        f.setVisible(true);
        f.getContentPane().setForeground(new Color(25, 25, 25));
        f.getContentPane().setBackground(new Color(25, 25, 25));


        JLabel l2 = new JLabel("What is your name?");
        l2.setBounds(130, 40, 400, 100);
        l2.setFont(new Font("Serif", Font.BOLD, 24));
        l2.setForeground(Color.white);
        f.add(l2);

        JTextField t1;
        t1 = new JTextField();
        t1.setBounds(150, 100, 200, 30);
        f.add(t1);


        f.setLayout(null);

        JButton b = new JButton("Next ->");//creating instance of JButton
        b.setBounds(200, 200, 100, 40);

        f.add(b);


        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                name = t1.getText();
                f.dispose();
                new DiffPage();
            }


        });


    }


}