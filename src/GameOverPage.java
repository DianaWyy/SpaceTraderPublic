import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;

public class  GameOverPage extends JFrame {

    public GameOverPage(boolean winGame) {

        JFrame f = new JFrame();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;


        f.setSize(width, height);

        try {
            BufferedImage bf = ImageIO.read(new File("pic/welcomepig.png"));
            f.setContentPane(new Backimage(bf));
        } catch(IOException e) {
            System.out.println("Something happened with picture");
        }

        // adding created component to the JFrame using my Backimage class

        JLabel l1;
        l1 = new JLabel("Game Over :(");
        if (winGame) {
            l1.setText("Congrats! You bought the universe my boi!");
        } else {
            l1.setText("Sorry you dead boi ;(");
        }
        l1.setBounds(width / 2 - 225, height / 2 - 200, 1000, 100);
        l1.setAlignmentX(Component.CENTER_ALIGNMENT);
        l1.setFont(new Font("Serif", Font.BOLD, 40));
        l1.setForeground(Color.white);

        f.add(l1);

        JButton b = new JButton("Start New Game"); //creating instance of JButton
        b.setFont(new Font("Serif", Font.BOLD, 30));
        b.setBounds(width / 2 - 200, height / 2 - 50, 400, 65);

        f.add(b);


        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new LoginPage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                f.dispose();
            }
        });

        //full screen
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setUndecorated(true);

        f.setLayout(null); //using no layout managers
        f.setVisible(true); //making the frame visible
        //f.getContentPane().setForeground(new Color(25, 25, 25));
        //f.getContentPane().setBackground(new Color(25, 25, 25));


    }
//
//    public static void main(String[] args) throws IOException {
//        WelcomePage mg = new WelcomePage();
//
//
//    }



}
