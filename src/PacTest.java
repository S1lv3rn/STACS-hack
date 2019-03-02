import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PacTest {
    public static void main (String[] args) {
        pac2 pac = new pac2();
        Pacman pacman = new Pacman();
        Boolean dead = false;

        try {
            pac.createBoard();
        } catch (IOException e) {
            e.printStackTrace();
        }

        pacman.initPacman();
        pac.display();


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (!dead) {
            try {
                reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
