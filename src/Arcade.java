import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Arcade implements ActionListener {
    private int clicks = 0;
    private JLabel label = new JLabel("Number of clicks:  0     ");
    private JFrame frame = new JFrame();
    private JList list;
    private JLabel coretext;

    public Arcade() {

        // the clickable button
        JButton button = new JButton("Click Me");
        button.addActionListener(this);
        coretext = new JLabel("Select your game");
        // the panel with the button and text
        JPanel panel = new JPanel();
        list = new JList(Arcade.game);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(4, 0));
        panel.add(coretext);
        panel.add(list);
        list.setSize(500, 500);
        list.setFixedCellHeight(20);
        list.setFixedCellWidth(140);
        panel.add(button);
        // set up the frame and display it
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        frame.pack();
        frame.setVisible(true);
    }

    // process the button clicks
    public void actionPerformed(ActionEvent e) {
        String str = (String) list.getSelectedValue();
        System.out.println(str);
        coretext.setText(str);
    }

    static String game[] = new String[2];

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
        game[1] = "Pacman";
        String gameenter = "";
        if (args.length != game.length) {
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
                        check = 1;
                        GameExecute(i);
                    }
                }
            }
            while (check == 0);
            voce.SpeechInterface.destroy();
        } else {
            for (int i = 0; i < game.length; i++) {
                if (game[i].equals(gameenter)) {
                    GameExecute(i);
                }
            }
        }
    }
}
