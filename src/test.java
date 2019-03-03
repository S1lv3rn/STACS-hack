import java.awt.*;
import java.io.IOException;
import javax.swing.*;

public class test{
public static void main(String[] args ) throws InterruptedException, IOException {
    Gui hello = new Gui();
    JFrame f = new JFrame();
    f.add(hello);
    f.setSize(500, 500);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Pac2 p = new Pac2();
    p.createBoard();
    //hello.work();

    while (true) {
        hello.validate();
        System.out.println(2);
        hello.repaint();
        Thread.sleep(10);
    }

}
}
