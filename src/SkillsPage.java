import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import java.awt.event.*;


public class SkillsPage {
    private JFrame f = new JFrame("Select your difficulties");
    public static int pilotSkill;
    public static int fighterSkill;
    public static int merchantSkill;
    public static int engineerSkill;

    private int skills;


    public SkillsPage() {

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(900, 500);
        f.setVisible(true);
        f.getContentPane().setForeground(new Color(25, 25, 25));
        f.getContentPane().setBackground(new Color(25, 25, 25));


        JLabel l2 = new JLabel(LoginPage.name + ", please select your skills");
        l2.setBounds(130, 40, 400, 100);
        l2.setFont(new Font("Serif", Font.BOLD, 24));
        l2.setForeground(Color.white);
        f.add(l2);

        // Check which difficulty for number of alloted skills

        switch(DiffPage.difficulty) {
            case "Easy": skills = 16; break;
            case "Medium": skills = 12; break;
            case "Hard": skills = 8; break;
            default: skills = 0;
        }

        JLabel l3 = new JLabel("You have " + skills + " skill points to distribute");
        l3.setBounds(130, 60, 400, 100);
        l3.setFont(new Font("Serif", Font.BOLD, 24));
        l3.setForeground(Color.white);
        f.add(l3);

        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JTextField t3 = new JTextField();
        JTextField t4 = new JTextField();
        t1.setBounds(140, 130, 100, 30);
        t2.setBounds(140, 160, 100, 30);
        t3.setBounds(140, 190, 100, 30);
        t4.setBounds(140, 220, 100, 30);
        t1.setFont(new Font("Serif", Font.BOLD, 14));
        t1.setForeground(Color.black);
        t2.setFont(new Font("Serif", Font.BOLD, 14));
        t2.setForeground(Color.black);
        t3.setFont(new Font("Serif", Font.BOLD, 14));
        t4.setFont(new Font("Serif", Font.BOLD, 14));
        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(t4);


        f.setLayout(null);

        JButton b = new JButton("Next ->");//creating instance of JButton
        b.setBounds(250, 250, 100, 40);

        f.add(b);

        JButton b2 = new JButton("<-- Prev");//creating instance of JButton
        b2.setBounds(150, 250, 100, 40);

        f.add(b2);

        t1.addActionListener(l -> {
                String s = t1.getText();
                pilotSkill = Integer.parseInt(s);});

        t2.addActionListener(l -> {
            String s = t2.getText();
            fighterSkill = Integer.parseInt(s);});

        t3.addActionListener(l -> {
            String s = t3.getText();
            merchantSkill = Integer.parseInt(s);});

        t4.addActionListener(l -> {
            String s = t4.getText();
            engineerSkill = Integer.parseInt(s);});



        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                if(pilotSkill + fighterSkill + merchantSkill + engineerSkill == skills) {
                    new DisplayPage();
                    f.dispose();
                }

            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new DiffPage();
                f.dispose();
            }
        });


    }


}