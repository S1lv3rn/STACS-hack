import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Pong_frame extends JPanel {
  // updates screen

    // public void createFrame() {
    //
    //     JFrame pongFrame = new JFrame("Pong");
    //
    //     pongFrame.setSize(2048, 2048);
    //     pongFrame.setVisible(true);
    //     pongFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //
    // }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillRect(50, 0, 30, 30);
    }
}
