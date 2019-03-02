package Arcade.impl;
public class Arcade {
static String game[] = new String[1];
    public static void main(String[] args) {
        game[0] = "Pong";
        String gameenter = new String();
        if (args.length != game.length)
        {
            System.out.println("Select game:");
            int count = 0;
            for(String gamelist:game)
            {
                System.out.println (++count + "." + gamelist);
            }
            System.out.println (gameenter);
            for (int i = 0; i< game.length; i++)
            {
                if (game[i].equals(gameenter))
                {
                    // execute the related game
                }
            }
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
