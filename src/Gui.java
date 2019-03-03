import javax.swing.*;
import java.awt.*;

    public class Gui extends JFrame {

        JButton[][] button;

        public void displayScreen() {
            Gui test = new Gui();
            test.work();
        }

        public void work() {
            long now = System.currentTimeMillis();
            JFrame frame = new JFrame("JPacMan"); // gives us title of application
            JPanel panel = new JPanel();
            JLabel pac2 = new JLabel();
            ImageIcon A = new ImageIcon("amex.png");
            ImageIcon B = new ImageIcon("bloomberg.jpg");
            ImageIcon J = new ImageIcon("jpm.jpg");
            ImageIcon T = new ImageIcon("talentticker.png");
            ImageIcon Pizza = new ImageIcon("pizza.png");
            ImageIcon Wall = new ImageIcon("wall.jpeg");
            ImageIcon Uni = new ImageIcon("uni.png");
            panel.add(pac2);
            frame.add(panel);
            JLabel score = new JLabel();


            frame.add(panel);
            frame.setSize(2048, 2048); // size of the applet
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

            panel.setLayout(new FlowLayout());
            panel.setLayout(null); // so that we xcan set the positioin of the butoons

            button = new JButton[36][28];




            for (int i = 0; i < Pac2.board.length; i++) {
                for (int j = 0; j < Pac2.board[i].length; j++) {
                    button[i][j].setBorderPainted(false);
                    button[i][j].setFocusPainted(false);
                    button[i][j].setContentAreaFilled(false);
                    if (Pac2.board[i][j] == '0') {
                        button[i][j] = new JButton(Wall);
                    } else if (Pac2.board[i][j] == '+' || Pac2.board[i][j] == '-') {
                        button[i][j] = new JButton(Pizza);
                    } else if (Pac2.board[i][j] == '<') {
                        button[i][j] = new JButton(Uni);
                        pac2.add(button[i][j]);
                    } else if (Pac2.board[i][j] == 'a') {
                    button[i][j] = new JButton(A);
                        pac2.add(button[i][j]);
                    }else if (Pac2.board[i][j] == 'b') {
                        button[i][j] = new JButton(B);
                        pac2.add(button[i][j]);
                    }else if (Pac2.board[i][j] == 'j') {
                        button[i][j] = new JButton(J);
                        pac2.add(button[i][j]);
                    }else if (Pac2.board[i][j] == 't') {
                        button[i][j] = new JButton(T);
                        pac2.add(button[i][j]);
                    }
                   pac2.add(button[i][j]);
                    button[i][j].setBounds(i*50,j*50,50,50);
            }





//            Timer timer = new Timer(2500, new ActionListener(){
//
//                boolean clicked = false;
//                @Override
//
//                public void actionPerformed(ActionEvent e) {
//                    clicked = false;
//                    int current = (int)(Math.random()*10);
//                    button[current].setIcon(crab);
//
//                    for (int i = 0; i< button.length; i++){
//                        if(i != current) {
//                            button[i].setIcon(crabstill);
//                        }
//                        button[i].addActionListener(this);
//
//                        button[i].addMouseListener(new MouseAdapter() {
//                                                       @Override
//                                                       public void mouseClicked(MouseEvent evt) {
//                                                           //	System.out.println(evt);
//                                                           if (!clicked) {
//                                                               clickedNumber++;
//                                                               clicked = true;
//                                                           }
//                                                       }
//                                                   }
//                        );
//                        if((System.currentTimeMillis()> (now + 60000)) || (clickedNumber>= 10) ) {
//                            frame.setVisible(false);
//                        }
//
//                    }
//                }
//
//            });
//            timer.start();

                score.setText("game over");
                pac2.add(score);
                panel.add(pac2);
                frame.add(panel);

            }

        }
    }
