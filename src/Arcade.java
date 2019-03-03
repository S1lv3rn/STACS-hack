//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.Scanner;
//import com.microsoft.cognitiveservices.speech.*;
//
//public class Arcade implements ActionListener {
//    private JFrame frame = new JFrame();
//    private JList list;
//    private JLabel coretext;
//    private static String game[] = new String[2];
//    static int check = 0;
//    public Arcade() {
//        // the clickable button
//        JButton button = new JButton("Click Me");
//        button.addActionListener(this);
//        coretext = new JLabel("Select your game");
//        coretext.setForeground(Color.WHITE);
//        // the panel with the button and text
//        JPanel panel = new JPanel();
//        list = new JList(Arcade.game);
//        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
//        panel.setLayout(new GridLayout(4, 0));
//        panel.add(coretext);
//        panel.add(list);
//        list.setSize(500, 500);
//        list.setFixedCellHeight(20);
//        list.setFixedCellWidth(140);
//        panel.add(button);
//        // set up the frame and display it
//        frame.add(panel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setTitle("GameMachine");
//        frame.pack();
//        frame.setVisible(true);
//        panel.setBackground(Color.BLACK);
//    }
//
//    // process the button clicks
//    public void actionPerformed(ActionEvent e){
//        try {
//            String str = (String) list.getSelectedValue();
//            GameExecute(list.getSelectedIndex());
//        }
//        catch (Exception cheese)
//        {
//            cheese.printStackTrace();
//        }
//    }
//
//    public static void GameExecute(int code) throws InterruptedException{
//        check = 1;
//        if (code == 0) {
//            Pong.main();
//        }
//        else if (code == 1)
//            Pacmain.main();
//    }
//    public static void main(String[] args) {
//        try{
//        int speechcheck = 1;
//        Arcade A = new Arcade();
//        SpeechConfig config = SpeechConfig.fromSubscription("54eeec34e6844d1dae7f02d1518cfbe0", "eastus");
//        voce.SpeechInterface.init("./lib", true, false,
//                "./lib/gram", "digits");
//        game[0] = "Pong";
//        game[1] = "Pacman";
//        String gameenter = "";
//        if (args.length != game.length) {
//            Scanner keyboard = new Scanner(System.in);
//            do {
//                System.out.println("Select game:");
//                voce.SpeechInterface.synthesize("Select game:");
//                int count = 0;
//                for (String gamelist : game) {
//                    System.out.println(++count + "." + gamelist);
//                    voce.SpeechInterface.synthesize(count + " " + gamelist);
//                }
//                if (speechcheck == 0)
//                    gameenter = keyboard.nextLine();
//                else {
//                    Thread.sleep(200);
//                    SpeechRecognizer recognizer = new SpeechRecognizer(config);
//                    {
//                        SpeechRecognitionResult result = recognizer.recognizeOnceAsync().get();
//                        System.out.println(result.getText());
//                    }
////                 //   voce.SpeechInterface.setRecognizerEnabled(true);
////                    while (voce.SpeechInterface.getRecognizerQueueSize() > 0) {
////                        //  gameenter = voce.SpeechInterface.popRecognizedString();
////                        System.out.println(voce.SpeechInterface.popRecognizedString());
////                    }
//
//                }
//                check = 0;
//                for (int i = 0; i < game.length; i++) {
//                    if (game[i].equals(gameenter)) {
//                        check = 1;
//                        GameExecute(i);
//                    }
//                }
//            }
//            while (check == 0);
//            voce.SpeechInterface.destroy();
//        } else {
//            for (int i = 0; i < game.length; i++) {
//                if (game[i].equals(gameenter)) {
//                    GameExecute(i);
//                }
//            }
//        }
//    }
//        catch(Exception ee)
//        {
//            System.out.println(ee);
//        }
//    }
//
//}
