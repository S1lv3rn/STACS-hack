import javax.swing.*;
import java.awt.*;


public class JPacMan  {

    JLabel[][] tile;

    public void display() {

        JFrame pacFrame = new JFrame("JPacMan");
        JPanel pacPanel = new JPanel();
        ImageIcon pizza = new ImageIcon("assets/pizza.png");


        for(int i = 0; i< 15; i++){
            for(int j = 0; j< 15; j++){
               tile[i][j] = new JLabel();
               tile[i][j].setIcon(pizza);
               pacPanel.add(tile[i][j]);
            }
        }


































































//        JFrame pacFrame = new JFrame("JPacMan");
//        pacFrame.setVisible(true);
//
//        pacFrame.setLayout(new FlowLayout());
//
//        //pacFrame.setLayout(null);
//
//        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
////        pacFrame.setSize(screensize.width, sc̣reensize.height);
//        pacFrame.setSize(640, 480);
//        pacFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        //pacFrame.setResizable(false);
//
//
//        JPanel pacPanel = new JPanel();
//        pacFrame.add(pacPanel);
//
//        pacPanel.setBorder(BorderFactory.createLineBorder(Color.white));
//
//        ImageIcon pizzaIcon = new ImageIcon("assets/pizza.png");
//
//        JLabel label = new JLabel(pizzaIcon);
//
//        ///pacPanel.setLocation(10, 10);
//
//        System.out.println(pacPanel.getLocation());
//
//        pacPanel.add(label);
//
//        MouseAdapter mouseAdapter = new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//                System.out.println("Mouse Event");
//            }
//        };
//
//        pacPanel.addMouseListener(mouseAdapter);
//
    }





}
