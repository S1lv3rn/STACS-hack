import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PacLabel extends JPanel{

    private BufferedImage image;

    public PacLabel() {
        try {
            image = ImageIO.read(new File("assets/pizza.png"));
        } catch (IOException ex) {
            throw new RuntimeException("image not found in the specified location");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
    }

}