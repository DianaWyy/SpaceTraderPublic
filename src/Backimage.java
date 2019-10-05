import javax.swing.*;
import java.awt.*;

public class Backimage extends JComponent {
    private Image i;

    //Creating Constructer
    public Backimage(Image i) {
        this.i = i;
    }

    //Overriding the paintComponent method
    @Override
    public void paintComponent(Graphics g) {

        g.drawImage(i, 0, 0, getWidth(), getHeight(), this);
        // Drawing image using drawImage method
    }
}
