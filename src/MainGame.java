import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


import javax.swing.*;
import java.awt.event.*;

public class MainGame extends JFrame {

    public MainGame() throws IOException {

        JFrame f = new JFrame();//creating instance of JFrame

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;


        f.setSize(width, height);

        BufferedImage bf = ImageIO.read(new File("pic/welcomepig.png"));

// adding created component to the JFrame using my backImage class


        f.setContentPane(new backImage(bf));


        JLabel l1;
        l1 = new JLabel("Space Trader");
        l1.setBounds(width / 2 - 225, height / 2 - 200, 500, 100);
        l1.setFont(new Font("Serif", Font.BOLD, 80));
        l1.setForeground(Color.white);

        f.add(l1);

        JButton b = new JButton("Start Game");//creating instance of JButton
        b.setFont(new Font("Serif", Font.BOLD, 30));
        b.setBounds(width / 2 - 100, height / 2 - 50, 200, 65);

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

        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
        //f.getContentPane().setForeground(new Color(25, 25, 25));
        //f.getContentPane().setBackground(new Color(25, 25, 25));


    }

    public static void main(String[] args) throws IOException {
        MainGame mg = new MainGame();


    }

}

class backImage extends JComponent {

    Image i;

    //Creating Constructer
    public backImage(Image i) {
        this.i = i;

    }

    //Overriding the paintComponent method
    @Override
    public void paintComponent(Graphics g) {

        g.drawImage(i, 0, 0, getWidth(), getHeight(), this);  // Drawing image using drawImage method

    }
}

