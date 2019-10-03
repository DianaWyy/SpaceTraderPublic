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

public class LoginPage extends JFrame {

    private static String name;
    private static String difficulty;
    private static int credits;
    private static int pilotSkill;
    private static int fighterSkill;
    private static int merchantSkill;
    private static int engineerSkill;
    private int skills = 0;


    public LoginPage() throws IOException {

        JFrame f = new JFrame("Config");

        // get width and height of screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        f.setSize(width, height);

        BufferedImage bf = ImageIO.read(new File("pic/loginpic.jpg"));


// adding created component to the JFrame using my backImage class


        f.setContentPane(new backImage(bf));

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setUndecorated(true); // full screen
        f.setVisible(true);
        f.getContentPane().setForeground(new Color(25, 25, 25));
        f.getContentPane().setBackground(new Color(25, 25, 25));
        f.setLayout(null);

        // Enter name
        JLabel askName = new JLabel("What is your name?");
        askName.setBounds(125, 70, 550, 100);
        askName.setFont(new Font("Serif", Font.BOLD, 50));
        askName.setForeground(Color.white);
        f.add(askName);

        JTextField tfName;
        tfName = new JTextField();
        tfName.setFont(new Font("Serif", Font.PLAIN, 40));
        tfName.setBounds(125, 170, 350, 75);
        f.add(tfName);


        // Select difficulty
        JLabel diff = new JLabel("Please select your difficulty");
        diff.setBounds(width / 2 + 50, 70, 600, 100);
        diff.setFont(new Font("Serif", Font.BOLD, 42));
        diff.setForeground(Color.white);
        f.add(diff);

        JRadioButton easy = new JRadioButton("Easy");
        JRadioButton medium = new JRadioButton("Medium");
        JRadioButton hard = new JRadioButton("Hard");
        easy.setBounds(width / 2 + 50, 180, 150, 50);
        medium.setBounds(width / 2 + 50, 230, 150, 50);
        hard.setBounds(width / 2 + 50, 280, 150, 50);

        ButtonGroup bg = new ButtonGroup();
        JRadioButton[] bts = new JRadioButton[]{easy, medium, hard};


        for (JRadioButton bt : bts) {
            bg.add(bt);
            bt.setFont(new Font("Serif", Font.BOLD, 32));
            bt.setForeground(Color.white);
            f.add(bt);
        }

        // Distribute skill points
        JLabel askDis = new JLabel("Please select your skills");
        askDis.setBounds(130, height / 2 - 50, 550, 100);
        askDis.setFont(new Font("Serif", Font.BOLD, 42));
        askDis.setForeground(Color.white);
        f.add(askDis);


        JLabel showPts = new JLabel("You have " + skills + " skill points to distribute");
        showPts.setBounds(130, height / 2 + 25, 550, 100);
        showPts.setFont(new Font("Serif", Font.BOLD, 32));
        showPts.setForeground(Color.white);
        f.add(showPts);

        JLabel pilot = new JLabel("Pilot");
        JLabel fighter = new JLabel("Fighter");
        JLabel merchant = new JLabel("Merchant");
        JLabel engineer = new JLabel("Engineer");
        pilot.setBounds(150, height / 2 + 100, 200, 50);
        fighter.setBounds(150, height / 2 + 150, 200, 50);
        merchant.setBounds(150, height / 2 + 200, 200, 50);
        engineer.setBounds(150, height / 2 + 250, 200, 50);

        JLabel[] attrLb = new JLabel[]{pilot, fighter, merchant, engineer};
        for (JLabel attr : attrLb) {
            attr.setFont(new Font("Serif", Font.BOLD, 32));
            attr.setForeground(Color.WHITE);
            f.add(attr);
        }


        // Create TextFields
        JTextField tfPilot = new JTextField();
        JTextField tfFighter = new JTextField();
        JTextField tfMerchant = new JTextField();
        JTextField tfEngineer = new JTextField();
        tfPilot.setBounds(350, height / 2 + 100, 100, 50);
        tfFighter.setBounds(350, height / 2 + 150, 100, 50);
        tfMerchant.setBounds(350, height / 2 + 200, 100, 50);
        tfEngineer.setBounds(350, height / 2 + 250, 100, 50);

        JTextField[] attrTf = new JTextField[]{tfPilot, tfFighter, tfMerchant, tfEngineer};
        for (JTextField attr : attrTf) {
            attr.setFont(new Font("Serif", Font.BOLD, 32));
            attr.setForeground(Color.black);
            f.add(attr);
        }


        easy.addActionListener(l -> {
            difficulty = "Easy";
            skills = 16;
            credits = 1000;
            showPts.setText("You have " + skills + " skill points to distribute");
        });
        medium.addActionListener(l -> {
            difficulty = "Medium";
            skills = 12;
            credits = 500;
            showPts.setText("You have " + skills + " skill points to distribute");
        });
        hard.addActionListener(l -> {
            difficulty = "Hard";
            skills = 8;
            credits = 100;
            showPts.setText("You have " + skills + " skill points to distribute");
        });


        JLabel showError = new JLabel("");
        showError.setBounds(width / 2 + 50, height / 2 + 150, 550, 100);
        showError.setFont(new Font("Serif", Font.BOLD, 32));
        showError.setForeground(Color.white);
        f.add(showError);

        // Add Next Button
        JButton next = new JButton("Next ->");//creating instance of JButton
        next.setFont(new Font("Serif", Font.BOLD, 40));
        next.setBounds(width - 250, height - 200, 200, 75);

        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                //check TextField
                name = tfName.getText();
                try {
                    pilotSkill = Integer.parseInt(tfPilot.getText());
                    fighterSkill = Integer.parseInt(tfFighter.getText());
                    merchantSkill = Integer.parseInt(tfMerchant.getText());
                    engineerSkill = Integer.parseInt(tfEngineer.getText());
                } catch (Exception e) {
                    showError.setText("Integer only plz...");
                }

                int sum = pilotSkill + fighterSkill + merchantSkill + engineerSkill;

                // check if all fields are filled
                if (name.equals("") || (!easy.isSelected() && !medium.isSelected() && !hard.isSelected())) {
                    showError.setText("You lAzY lil boi!");
                } else if (sum < skills) {
                    showError.setText("You still have " + (skills - sum) + " points to distribute");
                } else if (sum > skills) {
                    showError.setText("You gREedY lil boi!");
                } else {
                    new DisplayPage(name, difficulty, credits, pilotSkill, fighterSkill, merchantSkill, engineerSkill);
                    f.dispose();
                }
            }
        });
        f.add(next);

    }
}