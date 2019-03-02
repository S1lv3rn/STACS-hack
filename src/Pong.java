import javax.swing.*;
import java.awt.*;


public class Pong {

    //handles game logic



    public static void runPong(){


        JFrame frame = new JFrame("Pong");
        frame.add(new Pong_frame());
        frame.setSize(2048, 2048);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
