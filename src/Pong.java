import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class Pong extends JPanel{


    //handles game logic
    boolean pvp;
    int state = 0;
    int scWidth = 1000;
    int scHeight = 500;

    int p1Sc = 0;
    int p2Sc = 0;



    Ball ball = new Ball(scWidth/2 + 15, scHeight/2 + 15, pvp);
    Bat p1 = new Bat(20,scHeight/2, true);
    Bat p2 = new Bat(scWidth - 40, scHeight/2, false);

    ArrayList<Sprites> sprList = new ArrayList<>();






    Pong(int mode) {

        pvp = mode > 0;
        ball.pVp = pvp;

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

                } else if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
                    p2.goUp();

                } else if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
                    p2.goDown(scHeight);
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
            }
        };
        addKeyListener(listener);
        setFocusable(true);
    }





    public static void main(String[] args) throws InterruptedException{
        int mode = 1;
        int rounds = 0;
        Pong pong = new Pong(mode);
        boolean again = true;
        boolean play = true;
        boolean game = true;


        setUp(pong);

        while (again) {

            while (game) {
                while (play) {
                    pong.moveAll();

                    pong.validate();
                    pong.repaint();
                    Thread.sleep(5);
                } //finish a mode
            } // if 3 : switch then true :: display winner
        }//play again +
    }

    public static void runPong(){}

    public static boolean finRound(Pong p, int m) {

    }

    public static boolean finGame(Pong p, int m) {

    }

    public static boolean playAgain(Pong p, int m) {

    }













    public static void setUp(Pong p) throws InterruptedException {
      JFrame frame = new JFrame("Pong");

      p.sprList.add(p.ball);
      p.sprList.add(p.p1);
      p.sprList.add(p.p2);
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

        printScore(g);


    }

    private void moveAll() throws InterruptedException {

        ball.move(scHeight, scWidth);
        ball.collision(p1);
        ball.collision(p2);

    }

    private void printScore(Graphics g) {
        String s;

        if (pvp) {

            s = "Player 1 : " + ball.score1;
            g.setColor(Color.BLUE);
            g.drawString(s, 20, (scHeight - (scHeight/5)));

            g.setColor(Color.RED);
            s = "Player 2 : " + ball.score2;
            g.drawString(s, scWidth - 100, (scHeight - (scHeight/5)));

        } else {
            g.setColor(new Color( 139, 23, 122));

            s = "Score : " + ball.score0;
            g.drawString(s, (scWidth/2 - 50), (scHeight - (scHeight/5)));

        }
    }

    private void switchClick() {
        pvp = !pvp;
        ball.pVp = !ball.pVp;
    }
}
