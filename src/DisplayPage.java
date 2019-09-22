import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

import javax.swing.*;
public class DisplayPage{
    private JFrame f = new JFrame("Confirm");

    public DisplayPage() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setUndecorated(true); // full screen
        f.setVisible(true);
        f.getContentPane().setForeground(new Color(25, 25, 25));
        f.getContentPane().setBackground(new Color(25, 25, 25));

        JLabel name = new JLabel("Your selected username: "  + LoginPage.name);
        name.setAlignmentX(Component.CENTER_ALIGNMENT);
        name.setBounds(width/2, height/4, 400,50);
        name.setFont( new Font("Serif", Font.BOLD, 24));
        name.setForeground(Color.white);
        f.add(name);

        JLabel diff = new JLabel("Your selected difficulty: " + LoginPage.difficulty);
        diff.setAlignmentX(Component.CENTER_ALIGNMENT);
        diff.setBounds(width/2, height/4 + 50, 400,50);
        diff.setFont( new Font("Serif", Font.BOLD, 24));
        diff.setForeground(Color.white);
        f.add(diff);

        JLabel cred = new JLabel("Your available credits: " + LoginPage.credits);
        cred.setAlignmentX(Component.CENTER_ALIGNMENT);
        cred.setBounds(width/2, height/4 + 100, 400,50);
        cred.setFont( new Font("Serif", Font.BOLD, 24));
        cred.setForeground(Color.white);
        f.add(cred);

        JLabel pilot = new JLabel("Your Pilot skill points: " + LoginPage.pilotSkill);
        pilot.setAlignmentX(Component.CENTER_ALIGNMENT);
        pilot.setBounds(width/2, height/4 + 150, 400,50);
        pilot.setFont( new Font("Serif", Font.BOLD, 24));
        pilot.setForeground(Color.white);
        f.add(pilot);

        JLabel fighter = new JLabel("Your Fighter skill points: " + LoginPage.fighterSkill);
        fighter.setAlignmentX(Component.CENTER_ALIGNMENT);
        fighter.setBounds(width/2, height/4 + 200, 400,50);
        fighter.setFont( new Font("Serif", Font.BOLD, 24));
        fighter.setForeground(Color.white);
        f.add(fighter);

        JLabel merchant = new JLabel("Your Merchant skill points: " + LoginPage.merchantSkill);
        merchant.setAlignmentX(Component.CENTER_ALIGNMENT);
        merchant.setBounds(width/2, height/4 + 250, 400,50);
        merchant.setFont( new Font("Serif", Font.BOLD, 24));
        merchant.setForeground(Color.white);
        f.add(merchant);

        JLabel engineer = new JLabel("Your Engineer skill points: " + LoginPage.engineerSkill);
        engineer.setAlignmentX(Component.CENTER_ALIGNMENT);
        engineer.setBounds(width/2, height - 50, 400,50);
        engineer.setFont( new Font("Serif", Font.BOLD, 24));
        engineer.setForeground(Color.white);
        f.add(engineer);

    }

}