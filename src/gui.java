import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

    public class gui extends JFrame {

        JButton[][] button ;
        public void displayScreen(String [] args)
        {
            gui test = new gui();
            test.work();
        }
        public void work(){
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



            for(int i = 0 ; i< pac2.board.length; i++) {
                for (int j = 0; j < pac2.board[i].length; j++) {
                    button[i][j].setBorderPainted(false);
                    button[i][j].setFocusPainted(false);
                    button[i][j].setContentAreaFilled(false);
                    if(pac2.board[i][j] == '0'){
                        button[i][j] = new JButton(Wall);
                    }
                    else if(pac2.board[i][j] == '+' || pac2.board[i][j] == '-' ){
                        button[i][j] = new JButton(Pizza);
                    }
                    else if(pac2.board[i][j] == '<'){
                        button[i][j] = new JButton();
                    pac2.add(button[i][j]);
                }
            }



            button[0].setBounds(100, 500, 80,60);
            button[1].setBounds(100, 200, 80,60);
            button[2].setBounds(50, 400, 80,60);
            button[3].setBounds(1000, 500, 80,60);
            button[4].setBounds(1000, 200, 80,60);
            button[5].setBounds(1050, 400, 80,60);
            button[6].setBounds(500, 500, 80,60);
            button[7].setBounds(500, 200, 80,60);
            button[8].setBounds(300, 300, 80,60);
            button[9].setBounds(700, 500, 80,60);


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
