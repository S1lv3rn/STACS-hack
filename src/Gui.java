import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;

class Gui extends JFrame{

    static ImageIcon A = new ImageIcon("amex.png");
    static ImageIcon B = new ImageIcon("bloomberg.jpg");
    static ImageIcon J = new ImageIcon("jpm.jpg");
    static ImageIcon T = new ImageIcon("talentticker.png");
    static ImageIcon Pizza = new ImageIcon("pizza.png");
    static ImageIcon Wall = new ImageIcon("wall.jpeg");
    static ImageIcon Uni = new ImageIcon("uni.png");
    static ImageIcon Default = new ImageIcon("default.png");


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

                    //grid[i][j].setBackground(Color.black);




                    if (Pac2.board[i][j] == '0') {
                        grid[i][j].setIcon(Wall);
                    } else if (Pac2.board[i][j] == '+' || Pac2.board[i][j] == '-') {
                        grid[i][j].setIcon(Pizza);
                    } else if (Pac2.board[i][j] == '<') {
                        grid[i][j].setIcon(Uni);

                    } else if (Pac2.board[i][j] == 'a') {
                        grid[i][j].setIcon(A);

                    }else if (Pac2.board[i][j] == 'b') {
                        grid[i][j].setIcon(B);

                    }else if (Pac2.board[i][j] == 'j') {
                        grid[i][j].setIcon(J);

                    }else if (Pac2.board[i][j] == 't') {
                        grid[i][j].setIcon(T);

                    }else  {
                        grid[i][j].setIcon(Default);

                    }

                    grid[i][j].setBorder(new LineBorder(Color.BLACK));
                    grid[i][j].setOpaque(false);
                    panel.add(grid[i][j]);
                    add(panel);
                    pack();
                }
            }
        }
    }
