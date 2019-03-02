import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class pac2 {

    char[][]board = new char[36][28];

    public void createBoard() throws IOException {
        BufferedReader read = new BufferedReader(new FileReader("maze.txt"));
        String row = read.readLine();
        row.replace(" ", "");
        int i = 0;

        while(row!= null) {
             board[i] = row.toCharArray();
             i++;
             row = read.readLine();
            row.replace(" ", "");
        }

    }







public void display(){
    for(int i = 0; i< board.length; i++){
        for(int j = 0; j < board[i].length; j++){
            System.out.print(board[i][j]);
        }
        System.out.println();
    }

}
}
