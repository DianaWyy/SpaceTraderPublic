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
    private JFrame f = new JFrame("Config");
    public static String name;
    public static String difficulty;
    public static int credits;
    public static int pilotSkill;
    public static int fighterSkill;
    public static int merchantSkill;
    public static int engineerSkill;
    private int skills = 0;


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



        // Attribute skill points
        JLabel l3 = new JLabel("Please select your skills");
        l3.setBounds(130, height/2 - 50, 550, 100);
        l3.setFont(new Font("Serif", Font.BOLD, 42));
        l3.setForeground(Color.white);
        f.add(l3);

        // Check which difficulty for number of allocated skills
//
//        switch(difficulty) {
//            case "Easy": skills = 16; break;
//            case "Medium": skills = 12; break;
//            case "Hard": skills = 8; break;
//            default: skills = 0;
//        }


        JLabel l4 = new JLabel("You have " + skills + " skill points to distribute");
        l4.setBounds(130, height/2 + 25, 550, 100);
        l4.setFont(new Font("Serif", Font.BOLD, 32));
        l4.setForeground(Color.white);
        f.add(l4);

        // Create Label
        JLabel pilot = new JLabel("Pilot");
        JLabel fighter = new JLabel("Fighter");
        JLabel merchant = new JLabel("Merchant");
        JLabel engineer = new JLabel("Engineer");
        pilot.setBounds(150, height/2 + 100, 200, 50);
        fighter.setBounds(150, height/2 + 150, 200, 50);
        merchant.setBounds(150, height/2 + 200, 200, 50);
        engineer.setBounds(150, height/2 + 250, 200, 50);
        pilot.setFont(new Font("Serif", Font.BOLD, 32));
        fighter.setFont(new Font("Serif", Font.BOLD, 32));
        merchant.setFont(new Font("Serif", Font.BOLD, 32));
        engineer.setFont(new Font("Serif", Font.BOLD, 32));
        pilot.setForeground(Color.WHITE);
        fighter.setForeground(Color.WHITE);
        merchant.setForeground(Color.WHITE);
        engineer.setForeground(Color.WHITE);
        f.add(pilot);
        f.add(fighter);
        f.add(merchant);
        f.add(engineer);


        // Create TextFields
        JTextField t2 = new JTextField();
        JTextField t3 = new JTextField();
        JTextField t4 = new JTextField();
        JTextField t5 = new JTextField();
        t2.setBounds(350, height/2 + 100, 100, 50);
        t3.setBounds(350, height/2 + 150, 100, 50);
        t4.setBounds(350, height/2 + 200, 100, 50);
        t5.setBounds(350, height/2 + 250, 100, 50);
        t2.setFont(new Font("Serif", Font.BOLD, 32));
        t2.setForeground(Color.black);
        t3.setFont(new Font("Serif", Font.BOLD, 32));
        t3.setForeground(Color.black);
        t4.setFont(new Font("Serif", Font.BOLD, 32));
        t4.setForeground(Color.black);
        t5.setFont(new Font("Serif", Font.BOLD, 32));
        t5.setForeground(Color.black);
        f.add(t2);
        f.add(t3);
        f.add(t4);
        f.add(t5);


        r1.addActionListener(l -> {
            difficulty = "Easy";
            skills = 16;
            credits = 1000;
            l4.setText("You have " + skills + " skill points to distribute");
        });
        r2.addActionListener(l -> {
            difficulty = "Medium";
            skills = 12;
            credits = 500;
            l4.setText("You have " + skills + " skill points to distribute");
        });
        r3.addActionListener(l -> {
            difficulty = "Hard";
            skills = 8;
            credits = 100;
            l4.setText("You have " + skills + " skill points to distribute");
        });


        JLabel l5 = new JLabel("");
        l5.setBounds(width/2 + 50, height/2 + 150, 550, 100);
        l5.setFont(new Font("Serif", Font.BOLD, 32));
        l5.setForeground(Color.white);
        f.add(l5);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                //check TextField
                name = t1.getText();
                try {
                    pilotSkill = Integer.parseInt(t2.getText());
                    fighterSkill = Integer.parseInt(t3.getText());
                    merchantSkill = Integer.parseInt(t4.getText());
                    engineerSkill = Integer.parseInt(t5.getText());
                } catch (Exception e) {
                    l5.setText("Integer only plz...");
                }

                int sum = pilotSkill + fighterSkill + merchantSkill + engineerSkill;
                if(!name.equals("") && (r1.isSelected() || r2.isSelected() || r3.isSelected()) && sum == skills) {
                    new DisplayPage();
                    f.dispose();
                } else if (sum < skills){
                    l5.setText("You still have " + (skills - sum) + " points to distribute");
                } else {
                    l5.setText("You gREedY lil boi!");
                }
            }
        });
    }
}