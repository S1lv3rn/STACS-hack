import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class Pong extends JPanel{


    //handles game logic
    boolean pvp;
    boolean ans = false;
    int state = 0;
    int scWidth = 1000;
    int scHeight = 500;
    int rounds = 0;
    boolean playAgain = true;

    int p1Sc = 0;
    int p2Sc = 0;
    static int speed = 20;


    Ball ball = new Ball(scWidth/2 + 15, scHeight/2 + 15, pvp);
    Bat p1 = new Bat(20,scHeight/2, true);
    Bat p2 = new Bat(scWidth - 40, scHeight/2, false);

    ArrayList<Sprites> sprList = new ArrayList<Sprites>();






    Pong(int mode) {

        pvp = mode == 0;
        ball.pVp = pvp;

        KeyListener listener = new KeyListener() {

            public void keyTyped(KeyEvent keyEvent) {

                if (keyEvent.getKeyCode() == KeyEvent.VK_W) {
                    p1.goUp();

                } else if (keyEvent.getKeyCode() == KeyEvent.VK_S) {
                    p1.goDown(scHeight);
                }
            }

            public void keyPressed(KeyEvent keyEvent) {
                if (state == 0) {
                    if (keyEvent.getKeyCode() == KeyEvent.VK_W) {
                        p1.goUp();

                    } else if (keyEvent.getKeyCode() == KeyEvent.VK_S) {
                        p1.goDown(scHeight);

                    } else if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
                        p2.goUp();

                    } else if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
                        p2.goDown(scHeight);
                    }
                } else if (state == 3) {
                    if (keyEvent.getKeyCode() == KeyEvent.VK_Y) {
                        playAgain = true;
                        ans = true;
                        System.out.println("YES");

                    } else if (keyEvent.getKeyCode() == KeyEvent.VK_N) {
                        playAgain = false;
                        ans = true;
                        System.out.println("NO");

                    }
                }
            }

            public void keyReleased(KeyEvent keyEvent) {
            }
        };
        addKeyListener(listener);
        setFocusable(true);
    }

    public static void main() throws InterruptedException {
        int mode = 2;
        Pong pong = new Pong(mode);
        boolean again = true;
        boolean play = true;
        boolean game = true;


        setUp(pong);

        while (again) {
            System.out.println(2);
            pong.ans = false;


            while (game) {

                if (mode == 2) {
                    pong.state = 4;
                    printAndVal(pong);
                    Thread.sleep(100);
                }
                System.out.println("bruh");

                pong.state = 1;
                //introduce mode (1)
                printAndVal(pong);
                Thread.sleep(speed);
                System.out.println("bruh1");
                int speedcheck = 0;
                pong.state = 0;
                while (play) {
                    pong.moveAll();

                    printAndVal(pong); //upd8 game (0)
                    Thread.sleep(speed);
                    if (speed < 2) {
                        speedcheck = 1;
                    }
                    if (speed >= 15) {
                        speedcheck = 0;
                    }
                    if (speedcheck == 0) {
                        speed--;
                    } else {
                        speed++;
                    }
                    play = finRound(pong, mode);
//                    System.out.println("CHECKIN PL : " + play);
                } //finish a mode

                game = finGame(pong, mode);
                pong.state = 2;
                printAndVal(pong); // display winner (2)
                Thread.sleep(100);

                System.out.println("CHEKN: GG " + game);
                play = game;

                if (!game && mode == 2) {
                    pong.state = 5;
                    printAndVal(pong); // display combine winner (2)
                    Thread.sleep(50);

                } else if (mode == 2) {

                    //reset the game
                    pong.ball.reSet();
                    pong.switchClick();

                    if (pong.pvp) {
                        voce.SpeechInterface.synthesize("Now in competitive mode!");
                        System.out.println("Switch to PVP! ");

                    } else {
                        pong.rounds++;
                        voce.SpeechInterface.synthesize("Now in co-operative mode!");
                        System.out.println("Switch to COOP! R" + pong.rounds);
                    }
                }
            }

            while (!pong.ans) {
                pong.state = 3;
                printAndVal(pong); // check play again (3)
                Thread.sleep(10);
            }
            again = pong.playAgain;
            System.out.println("BR8! " + again);

            if (again) {
                game = true;
                play = true;
                pong.ball.reSet();
            }
            System.out.println(1);
        }

        System.out.println(4);
        Window win = SwingUtilities.getWindowAncestor(pong);
        win.dispose();
    }

    public static void runPong(){}

    public static void printAndVal(Pong p) {
        p.validate();
        p.repaint();
    }

    public static boolean finRound(Pong p, int m) {
        //this is allocating the scores

        if (p.pvp) {
            if (p.ball.score1 == 0 || p.ball.score2 == 0) {
                if (m == 0) {
                    p.p1Sc = p.ball.score1;
                    p.p2Sc = p.ball.score2;

                    //for combine
                } else {
                    if (p.ball.score1 > p.ball.score2) {
                        p.p1Sc += p.ball.score0;

                    } else {
                        p.p2Sc += p.ball.score0;
                    }
                }
                return false;

            } else {
                return true;
            }
        } else {
            //         System.out.println("CHEKIN AND " + p.ball.coopPlay);
            return p.ball.coopPlay;
        }
    }

    public static boolean finGame(Pong p, int m) {
        //this print whoevers won

        if (m == 0) {
            //pvp
            if (p.p1Sc > p.p2Sc) {
                voce.SpeechInterface.synthesize("PLAYER 1 WINS. PLAYER 2 is extremely LOW QUALITY");
                System.out.println("PLAYER 1 WINS");
            } else {
                voce.SpeechInterface.synthesize("PLAYER 2 IS THE BOSS. PLAYER 1 is very junk QUALITY");
                System.out.println("PLAYER 2 WINS");
            }
            return false;

        } else if (m == 1) {
            voce.SpeechInterface.synthesize("TOTAL POINTS : " + p.ball.score0);
            System.out.println("TOTAL POINTS : " + p.ball.score0);
            return false;

            //combine
        } else if (m == 2) {
            if (p.rounds >= 5) {
                if (p.pvp) {
                    //add scores and stuff
                    if (p.p1Sc > p.p2Sc) {
                        voce.SpeechInterface.synthesize("PLAYER 1 WINS. PLAYER 2 is extremely LOW QUALITY");
                        System.out.println("C: PLAYER 1 WINS");

                    } else {
                        voce.SpeechInterface.synthesize("PLAYER 2 IS THE BOSS. PLAYER 1 is very junk QUALITY");
                        System.out.println("C: PLAYER 2 WINS");
                    }
                    return false;
                }

            }
        }
        return true;
    }

//    public static boolean playAgain(Pong p, int m) {
//
//
//        if (p.gameOver) {
//
//
//        }
//    }







    public static void setUp(Pong p) {
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

        if (pvp) {
            setBackground(new Color(170, 130, 124));

        } else {
            setBackground(new Color(135, 170, 159));
        }

        if (state == 0) {

            g2d.setColor(Color.BLACK);
            for (Sprites s : sprList) {
                s.draw(g2d);
            }

            printScore(g);

        } else if (state == 1) {
            //this introduces the mode

            g.setColor(Color.BLACK);

            if (pvp) {
                g.drawString("COMPETITIVE  MODE", scWidth/2, scHeight/2);

            } else {
                g.drawString("CO-OPERATIVE MODE", scWidth/2, scHeight/2);
            }


        } else if (state == 2) {
            if (pvp) {
                if (p1Sc > p2Sc) {
                    g.drawString("PLAYER 1 WINS", scWidth/2, scHeight/2);

                } else {
                    g.drawString("PLAYER 2 WINS", scWidth/2, scHeight/2);
                }
            }

        } else if (state == 3) {
            voce.SpeechInterface.synthesize("PLAY AGAIN? \n(Y/N)");
            g.drawString("PLAY AGAIN? \n(Y/N)", scWidth/2, scHeight/2);

        } else if (state == 4) {
            setBackground(new Color(169, 108, 170));
            g.setColor(Color.BLACK);
            g.drawString("COMBINATION", scWidth/2, scHeight/2);

        } else if (state == 5) {
            setBackground(new Color(169, 108, 170));
            g.setColor(Color.BLACK);
            if (p1Sc > p2Sc) {
                voce.SpeechInterface.synthesize("C: PLAYER 1 WINS");
                g.drawString("C: PLAYER 1 WINS", scWidth/2, scHeight/2);

            } else {
                voce.SpeechInterface.synthesize("C: PLAYER 2 WINS");
                g.drawString("C: PLAYER 2 WINS", scWidth/2, scHeight/2);
            }


        }


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
