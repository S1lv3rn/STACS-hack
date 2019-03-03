import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Pac2 {

    public static char[][] board = new char[36][28];
    static int size = 30 ;

    public void createBoard() throws IOException {
        BufferedReader read = new BufferedReader(new FileReader("maze.txt"));
        String row = read.readLine();
        int i = 0;

        while (row != null) {

            row = row.replace(" ", "");
            board[i] = row.toCharArray();
            i++;
            row = read.readLine();

        }

    }

    public void display() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];


                System.out.print(board[i][j]);
            }
            System.out.println();
        }

    }

    public static void display2(Graphics2D g) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.println(board[i][j]);

                switch (board[i][j]) {
                    case '0' : g.setColor(Color.BLACK); break;
                    case '-' : g.setColor(new Color(90, 128, 157)); break;
                    case '+' : g.setColor(new Color(90, 109, 157)); break;
                    case '|' : g.setColor(new Color(95, 98, 157)); break;

                }
                g.fillRect(i* size, j*size, size, size);
            }
            System.out.println();
        }

    }


    public char[][] getBoard() {
        return board;
    }
}
