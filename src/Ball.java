import java.awt.*;

public class Ball extends Sprites {

    Ball() {
        super(30,30);
    }

    @Override
    public void draw(Graphics2D g) {
        g.fillOval(x, y, lenX, lenY);
    }
}
