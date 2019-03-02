import java.util.Scanner;

public class Arcade {
    static String game[] = new String[1];

    public static void GameExecute(int code) {
        if (code == 0) {
            Pong.runPong();
        }
    }

    int speech = 0;

    public static void main(String[] args) throws InterruptedException {
        voce.SpeechInterface.init("./lib", true, true,
                "./lib/gram", "digits");
        int check = 0;
        game[0] = "Pong";
        String gameenter = "";
        if (args.length != game.length)
        {
            Scanner keyboard = new Scanner(System.in);
            do {
                System.out.println("Select game:");
                voce.SpeechInterface.synthesize("Select game:");
                int count = 0;
                for (String gamelist : game) {
                    System.out.println(++count + "." + gamelist);
                    voce.SpeechInterface.synthesize(count + " " + gamelist);
                }
                if (check == 0)
                    gameenter = keyboard.nextLine();
                else {
                    Thread.sleep(200);
                    voce.SpeechInterface.setRecognizerEnabled(true);
                    while (voce.SpeechInterface.getRecognizerQueueSize() > 0) {
                        //  gameenter = voce.SpeechInterface.popRecognizedString();
                        System.out.println(voce.SpeechInterface.popRecognizedString());
                    }
                }
                check = 0;
                for (int i = 0; i < game.length; i++) {
                    if (game[i].equals(gameenter)) {
                        check = i;
                        // execute the related game
                    }
                }
            }
            while (check == 0);
            voce.SpeechInterface.destroy();
        }
        else
        {
            for (int i = 0; i< game.length; i++)
            {
                if (game[i].equals(gameenter))
                {
                    GameExecute(i);
                }
            }
        }
    }
}
