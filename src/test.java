import java.awt.*;
import javax.swing.*;

public class test{
public static void main(String[] args ) throws InterruptedException{
    Gui hello = new Gui();
    hello.work();

    while (true) {
        hello.validate();
        hello.repaint();
        Thread.sleep(20);
    }

}
}
