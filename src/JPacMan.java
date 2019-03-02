import javax.swing.*;
import java.awt.*;

public class JPacMan {


    public void display() {

        JFrame pacFrame = new JFrame("JPacMan");
        pacFrame.setVisible(true);
        //pacFrame.getContentPane().setBackground(Color.BLACK);


        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        pacFrame.setSize(screensize.width, screensize.height);
        pacFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pacPanel = new JPanel();
        pacFrame.add(pacPanel);
        pacPanel.setBorder(BorderFactory.createLineBorder(Color.white));

    }





}
