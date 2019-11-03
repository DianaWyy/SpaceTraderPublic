import javax.swing.*;
import java.awt.*;

public class BanditPage {
    private Player p;
    private Ship s;


    //todo set player region set ship fuel


    public BanditPage(Player p, Ship s) {
        //put into instance variables
        this.p = p;
        this.s = s;

        //UI layout
        JFrame frame=new JFrame("Bandit Encountered!");
        frame.setSize(1280, 720);
        JPanel jp=new JPanel();

        JLabel message=new JLabel("A wild bandit has appeared!");
        JButton pay=new JButton("PAY");
        JButton flee=new JButton("FLEE");
        JButton fight=new JButton("FIGHT");
        JButton negotiate=new JButton("NEGOTIATE");

        jp.add(message);
        jp.add(pay);
        jp.add(flee);
        jp.add(fight);
        jp.add(negotiate);
        negotiate.setEnabled(false);

        frame.add(jp);
        frame.setBounds(300, 200, 600, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



    public void pay() {
        if (p.getCredits() < 100) {
            if (s.getCargoList().size() == 0) {
                s.setCurrHealth(s.getCurrHealth() - 1);
            } else {

            }
        }
    }

    public static void main(String[] args) {
        JFrame frame=new JFrame("Bandit Encountered!");
        frame.setSize(1280, 720);
        frame.setLayout(new BorderLayout());
        JPanel jp=new JPanel();

        JLabel message=new JLabel("A wild bandit has appeared!", JLabel.CENTER);
        JLabel banditIcon= new JLabel(new ImageIcon("pic/bandit.png"));
        JButton pay=new JButton("PAY");
        JButton flee=new JButton("FLEE");
        JButton fight=new JButton("FIGHT");
        JButton negotiate=new JButton("NEGOTIATE");

        frame.add(banditIcon, BorderLayout.NORTH);
        frame.add(message, BorderLayout.CENTER);
        jp.add(pay);
        jp.add(flee);
        jp.add(fight);
        jp.add(negotiate);
        negotiate.setEnabled(false);

        frame.add(jp, BorderLayout.SOUTH);
        frame.setBounds(300, 200, 600, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
