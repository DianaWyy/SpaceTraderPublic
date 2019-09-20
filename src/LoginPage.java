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

public class LoginPage {
    private JFrame f = new JFrame("Second");
    public static String name;
    public static String difficulty = "N/A";


    public LoginPage() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setUndecorated(true); // full screen
        f.setVisible(true);
        f.getContentPane().setForeground(new Color(25, 25, 25));
        f.getContentPane().setBackground(new Color(25, 25, 25));


        // Enter name
        JLabel l2 = new JLabel("What is your name?");
        l2.setBounds(125, 70, 550, 100);
        l2.setFont(new Font("Serif", Font.BOLD, 50));
        l2.setForeground(Color.white);
        f.add(l2);

        JTextField t1;
        t1 = new JTextField();
        t1.setFont(new Font("Serif", Font.PLAIN, 40));
        t1.setBounds(125, 170, 350, 75);
        f.add(t1);


        f.setLayout(null);

        JButton b = new JButton("Next ->");//creating instance of JButton
        b.setFont(new Font("Serif", Font.BOLD, 40));
        b.setBounds(width - 250, height - 200, 200, 75);

        f.add(b);


        // Select difficulty
        JLabel diff = new JLabel("Please select your difficulty");
        diff.setBounds(width/2 + 50, 70, 600, 100);
        diff.setFont(new Font("Serif", Font.BOLD, 42));
        diff.setForeground(Color.white);
        f.add(diff);

        JRadioButton r1 = new JRadioButton("Easy");
        JRadioButton r2 = new JRadioButton("Medium");
        JRadioButton r3 = new JRadioButton("Hard");
        r1.setBounds(width/2 + 50, 180, 150, 50);
        r2.setBounds(width/2 + 50, 230, 150, 50);
        r3.setBounds(width/2 + 50, 280, 150, 50);
        ButtonGroup bg = new ButtonGroup();
        r1.setFont(new Font("Serif", Font.BOLD, 32));
        r1.setForeground(Color.white);
        r2.setFont(new Font("Serif", Font.BOLD, 32));
        r2.setForeground(Color.white);
        r3.setFont(new Font("Serif", Font.BOLD, 32));
        r3.setForeground(Color.white);
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        f.add(r1);
        f.add(r2);
        f.add(r3);


        f.setLayout(null);

        r1.addActionListener(l ->
                difficulty = "Easy");
        r2.addActionListener(l ->
                difficulty = "Medium");
        r3.addActionListener(l ->
                difficulty = "Hard");
    }


}