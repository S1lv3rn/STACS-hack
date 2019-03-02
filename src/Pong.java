import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class Pong extends JPanel{


    //handles game logic
    int scWidth = 1000;
    int scHeight = 500;
    Ball ball = new Ball(0,5);
    Bat p1 = new Bat(20,0);
    ArrayList<Sprites> sprList = new ArrayList<>();

    Pong() {
        KeyListener listener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

                if (keyEvent.getKeyCode() == KeyEvent.VK_W) {
                    p1.goUp();

                } else if (keyEvent.getKeyCode() == KeyEvent.VK_S) {
                    p1.goDown(scHeight);
                }
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.VK_W) {
                    p1.goUp();

                } else if (keyEvent.getKeyCode() == KeyEvent.VK_S) {
                    p1.goDown(scHeight);
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
            }
        };
        addKeyListener(listener);
        setFocusable(true);
    }




    public static void main() throws InterruptedException{
        Pong pong = new Pong();

        setUp(pong);


        while (true) {
            pong.moveAll();

            pong.validate();
            pong.repaint();
            Thread.sleep(5);
        }


    }

    public static void runPong(){}

    public static void setUp(Pong p) throws InterruptedException {
      JFrame frame = new JFrame("Pong");

      p.sprList.add(p.ball);
      p.sprList.add(p.p1);
      frame.add(p);

      frame.setSize(p.scWidth, p.scHeight);
      frame.setVisible(true);
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      p.scHeight = p.getHeight();

    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Sprites s : sprList) {
            s.draw(g2d);
        }

    }

    public void moveAll() {

        ball.move(scHeight, scWidth);
        ball.collision(p1);

    }






}
