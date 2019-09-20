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

public class DiffPage {
    private JFrame f = new JFrame("Select your difficulties");
    public static String difficulty = "N/A";


    public DiffPage() {

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(900, 500);
        f.setVisible(true);
        f.getContentPane().setForeground(new Color(25, 25, 25));
        f.getContentPane().setBackground(new Color(25, 25, 25));


        JLabel l2 = new JLabel(LoginPage.name + ", please select your difficulty");
        l2.setBounds(130, 40, 400, 100);
        l2.setFont(new Font("Serif", Font.BOLD, 24));
        l2.setForeground(Color.white);
        f.add(l2);

        JRadioButton r1 = new JRadioButton("Easy");
        JRadioButton r2 = new JRadioButton("Medium");
        JRadioButton r3 = new JRadioButton("Hard");
        r1.setBounds(140, 130, 100, 30);
        r2.setBounds(140, 160, 100, 30);
        r3.setBounds(140, 190, 100, 30);
        ButtonGroup bg = new ButtonGroup();
        r1.setFont(new Font("Serif", Font.BOLD, 14));
        r1.setForeground(Color.white);
        r2.setFont(new Font("Serif", Font.BOLD, 14));
        r2.setForeground(Color.white);
        r3.setFont(new Font("Serif", Font.BOLD, 14));
        r3.setForeground(Color.white);
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        f.add(r1);
        f.add(r2);
        f.add(r3);


        f.setLayout(null);

        JButton b = new JButton("Next ->");//creating instance of JButton
        b.setBounds(250, 250, 100, 40);

        f.add(b);

        JButton b2 = new JButton("<-- Prev");//creating instance of JButton
        b2.setBounds(150, 250, 100, 40);

        f.add(b2);

        r1.addActionListener(l ->
                difficulty = "Easy");

        r2.addActionListener(l ->
                difficulty = "Medium");

        r3.addActionListener(l ->
                difficulty = "Hard");


        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new SkillsPage();
                f.dispose();
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new LoginPage();
                f.dispose();
            }
        });


    }


}