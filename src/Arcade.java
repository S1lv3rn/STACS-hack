import java.util.Scanner;

public class Arcade {
static String game[] = new String[1];
public void GameExecute(int code)
{
    if (code == 0)
    {

    }
}
    public static void main(String[] args) {
        int check = 0;
        game[0] = "Pong";
        String gameenter = new String();
        if (args.length != game.length)
        {
            Scanner keyboard = new Scanner(System.in);
            do {
                System.out.println("Select game:");
                int count = 0;
                for (String gamelist : game) {
                    System.out.println(++count + "." + gamelist);
                }
                gameenter = keyboard.nextLine();
                check = 0;
                for (int i = 0; i < game.length; i++) {
                    if (game[i].equals(gameenter)) {
                        check = 1;
                        // execute the related game
                    }
                }
            }
            while (check == 0);
        }
        else
        {
            for (int i = 0; i< game.length; i++)
            {
                if (game[i].equals(gameenter))
                {
                    // execute the related game
                }
            }
        }
    }
}
