import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PacTest {
    public static void main (String[] args) {
        Pac2 pac = new Pac2();
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

        try {
            while (!dead) {
                System.out.println("Move: ");
                String action = reader.readLine();
                char dir = action.toLowerCase().charAt(0);
                System.out.println(dir);
                pacman.movePacman(dir);
                pac.display();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
