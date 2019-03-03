import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;

class Gui extends JFrame{

<<<<<<< HEAD
        JLabel[][] Label;
=======
    static ImageIcon A = new ImageIcon("amex.png");
    static ImageIcon B = new ImageIcon("bloomberg.jpg");
    static ImageIcon J = new ImageIcon("jpm.jpg");
    static ImageIcon T = new ImageIcon("talentticker.png");
    static ImageIcon Pizza = new ImageIcon("pizza.png");
    static ImageIcon Wall = new ImageIcon("wall.jpeg");
    static ImageIcon Uni = new ImageIcon("uni.png");
    static ImageIcon Default = new ImageIcon("default.png");
>>>>>>> 1f588c71d319423b466029197d36b4019f833177


    public void work(){

            JPanel panel = new JPanel();
            getContentPane().add(panel);

            int row = 36;
            int col = 28;

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 500, 500);
            panel.setLayout(new GridLayout(row, col));
            setVisible(true);

            JLabel[][] grid= new JLabel[row][col];
            for (int i = 0; i < row; i++){
                for (int j = 0; j < col; j++){
                    grid[i][j] = new JLabel();

<<<<<<< HEAD
            Label = new JLabel[36][28];
=======
                    //grid[i][j].setBackground(Color.black);
>>>>>>> 1f588c71d319423b466029197d36b4019f833177




<<<<<<< HEAD
            for (int i = 0; i < Pac2.board.length; i++) {
                for (int j = 0; j < Pac2.board[i].length; j++) {
//                    Label[i][j].setBorderPainted(false);
//                    Label[i][j].setFocusPainted(false);
//                    Label[i][j].setContentAreaFilled(false);
                    if (Pac2.board[i][j] == '0') {
                        Label[i][j] = new JLabel(Wall);
                    } else if (Pac2.board[i][j] == '+' || Pac2.board[i][j] == '-') {
                        Label[i][j] = new JLabel(Pizza);
                    } else if (Pac2.board[i][j] == '<') {
                        Label[i][j] = new JLabel(Uni);
                        pac2.add(Label[i][j]);
                    } else if (Pac2.board[i][j] == 'a') {
                    Label[i][j] = new JLabel(A);
                        pac2.add(Label[i][j]);
                    }else if (Pac2.board[i][j] == 'b') {
                        Label[i][j] = new JLabel(B);
                        pac2.add(Label[i][j]);
                    }else if (Pac2.board[i][j] == 'j') {
                        Label[i][j] = new JLabel(J);
                        pac2.add(Label[i][j]);
                    }else if (Pac2.board[i][j] == 't') {
                        Label[i][j] = new JLabel(T);
                        pac2.add(Label[i][j]);
                    }
                   pac2.add(Label[i][j]);
                    Label[i][j].setBounds(i*50,j*50,50,50);
            }
=======
                    if (Pac2.board[i][j] == '0') {
                        grid[i][j].setIcon(Wall);
                    } else if (Pac2.board[i][j] == '+' || Pac2.board[i][j] == '-') {
                        grid[i][j].setIcon(Pizza);
                    } else if (Pac2.board[i][j] == '<') {
                        grid[i][j].setIcon(Uni);

                    } else if (Pac2.board[i][j] == 'a') {
                        grid[i][j].setIcon(A);
>>>>>>> 1f588c71d319423b466029197d36b4019f833177

                    }else if (Pac2.board[i][j] == 'b') {
                        grid[i][j].setIcon(B);

                    }else if (Pac2.board[i][j] == 'j') {
                        grid[i][j].setIcon(J);

                    }else if (Pac2.board[i][j] == 't') {
                        grid[i][j].setIcon(T);

                    }else  {
                        grid[i][j].setIcon(Default);

<<<<<<< HEAD
//            Timer timer = new Timer(2500, new ActionListener(){
//
//                boolean clicked = false;
//                @Override
//
//                public void actionPerformed(ActionEvent e) {
//                    clicked = false;
//                    int current = (int)(Math.random()*10);
//                    Label[current].setIcon(crab);
//
//                    for (int i = 0; i< Label.length; i++){
//                        if(i != current) {
//                            Label[i].setIcon(crabstill);
//                        }
//                        Label[i].addActionListener(this);
//
//                        Label[i].addMouseListener(new MouseAdapter() {
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
=======
                    }
>>>>>>> 1f588c71d319423b466029197d36b4019f833177

                    grid[i][j].setBorder(new LineBorder(Color.BLACK));
                    grid[i][j].setOpaque(false);
                    panel.add(grid[i][j]);
                    add(panel);
                    pack();
                }
            }
        }
    }
