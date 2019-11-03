import javax.swing.*;
import java.awt.*;

public class BanditPage {
    private Player p;
    private Ship s;



    public BanditPage(Player p, Ship s, Region selected, double fuel, MapPage mp) {
        //put into instance variables
        this.p = p;
        this.s = s;

        //UI layout
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
        JButton leave=new JButton("Keep Travelling..");

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
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //action events
        pay.addActionListener(l -> {
            if (p.getCredits() < 100) {
                if (s.getCargoList().size() == 0) {
                    s.setCurrHealth(s.getCurrHealth() - 1);
                    message.setText("You don't have enough money or any cargo! The robbers damaged your ship with anger!");
                    frame.remove(jp);
                    frame.add(leave, BorderLayout.SOUTH);
                    p.setCurrentRegion(selected);
                    s.decreaseCurrFuelCapacity(fuel);
                } else {
                    s.clearCargo();
                    message.setText("You don't have enough money! The robbers took all your inventory!");
                    frame.remove(jp);
                    frame.add(leave, BorderLayout.SOUTH);
                    p.setCurrentRegion(selected);
                    s.decreaseCurrFuelCapacity(fuel);
                }
            } else {
                p.setCredits(p.getCredits() - 100);
                message.setText("You chose to pay the bandit 100c! GOD DAMN ROBBERS! You'll get them next time!");
                frame.remove(jp);
                frame.add(leave, BorderLayout.SOUTH);
                p.setCurrentRegion(selected);
                s.decreaseCurrFuelCapacity(fuel);
            }
        });
        flee.addActionListener(l -> {
            if (p.getPilotSkill()*Math.random() > 1) {
                s.decreaseCurrFuelCapacity(fuel);
                message.setText("You ran away! Not so lucky next time!");
                frame.remove(jp);
                frame.add(leave, BorderLayout.SOUTH);
            } else {
                p.setCurrentRegion(selected);
                s.decreaseCurrFuelCapacity(fuel);
                s.setCurrHealth(s.getCurrHealth() - 1);
                p.setCredits(0);
                message.setText("You failed to run away! The bandits took all your credits and hit your ship!");
                frame.remove(jp);
                frame.add(leave, BorderLayout.SOUTH);
            }
        });
        fight.addActionListener(l -> {
            if (p.getFighterSkill()*Math.random() > 1) {
                p.setCurrentRegion(selected);
                s.decreaseCurrFuelCapacity(fuel);
                p.setCredits(p.getCredits() + 1000);
                message.setText("You completely destroyed the bandits! You get 1000 credit reward!");
                frame.remove(jp);
                frame.add(leave, BorderLayout.SOUTH);
            } else {
                p.setCurrentRegion(selected);
                s.decreaseCurrFuelCapacity(fuel);
                s.setCurrHealth(s.getCurrHealth() - 1);
                p.setCredits(0);
                message.setText("The bandits completely destroyed you! They took all your credits and hit your ship!");
                frame.remove(jp);
                frame.add(leave, BorderLayout.SOUTH);
            }
        });
        leave.addActionListener(l -> {
            frame.dispose();
            MapPage bruh = new MapPage(mp.getRegions(), p, mp.getGame());
            new RegionPage(p.getCurrentRegion(), p, bruh);
        });
    }


//    public static void main(String[] args) {
//        JFrame frame=new JFrame("Bandit Encountered!");
//        frame.setSize(1280, 720);
//        frame.setLayout(new BorderLayout());
//        JPanel jp=new JPanel();
//
//        JLabel message=new JLabel("A wild bandit has appeared!", JLabel.CENTER);
//        JLabel banditIcon= new JLabel(new ImageIcon("pic/bandit.png"));
//        JButton pay=new JButton("PAY");
//        JButton flee=new JButton("FLEE");
//        JButton fight=new JButton("FIGHT");
//        JButton negotiate=new JButton("NEGOTIATE");
//        JButton leave=new JButton("Keep Travelling..");
//
//        frame.add(banditIcon, BorderLayout.NORTH);
//        frame.add(message, BorderLayout.CENTER);
//        jp.add(pay);
//        jp.add(flee);
//        jp.add(fight);
//        jp.add(negotiate);
//        negotiate.setEnabled(false);
//
//        frame.add(jp, BorderLayout.SOUTH);
//        frame.setBounds(300, 200, 600, 300);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        pay.addActionListener(a -> {
//            message.setText("You chose to pay the bandit 100c! GOD DAMN ROBBERS! You'll get them next time!");
//            frame.remove(jp);
//            frame.add(leave, BorderLayout.SOUTH);
//        });
//    }
}
