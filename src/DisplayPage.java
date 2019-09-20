import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;
import java.awt.event.*;

import javax.swing.*;
public class DisplayPage{
    private JFrame f = new JFrame("Entered information");

    public DisplayPage() {

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(900,500);
        f.setVisible(true);
        f.getContentPane().setForeground(new Color(25, 25, 25));
        f.getContentPane().setBackground(new Color(25, 25, 25));


        JLabel l2=new JLabel("Your selected username: "  + LoginPage.name);
        l2.setBounds(150,40, 400,100);
        l2.setFont( new Font("Serif",Font.BOLD, 24));
        l2.setForeground(Color.white);
        f.add(l2);

        JLabel l3=new JLabel("Your selected difficulty: " + DiffPage.difficulty);
        l3.setBounds(150,80, 400,100);
        l3.setFont( new Font("Serif",Font.BOLD, 24));
        l3.setForeground(Color.white);
        f.add(l3);




    }












}