import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PacTest {
    public static void main (String[] args) {
        Pac2 pac = new Pac2();
        Gui panel = new Gui();
        Pacman pacman = new Pacman();
        ZombieStudents zombieA = new ZombieStudents('a');
        ZombieStudents zombieB = new ZombieStudents('b');
        ZombieStudents zombieC = new ZombieStudents('c');
        ZombieStudents zombieD = new ZombieStudents('d');

        Boolean dead = false;

        try {
            pac.createBoard();
        } catch (IOException e) {
            e.printStackTrace();
        }

        pacman.initcharacter();

        zombieA.setRow(14);
        zombieB.setRow(14);
        zombieC.setRow(14);
        zombieC.setRow(14);

        zombieA.setColumn(11);
        zombieB.setColumn(12);
        zombieC.setColumn(13);
        zombieD.setColumn(14);
        pac.display();


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (!dead) {
                System.out.println("Move: ");
                String action = reader.readLine();
                char dir = action.toLowerCase().charAt(0);
                System.out.println(dir);
                pacman.moveCharacter(dir);
                pac.display();
//                panel.validate();
                panel.repaint();



                //System.out.println("=====");


            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
