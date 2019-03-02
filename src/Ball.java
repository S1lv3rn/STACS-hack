import java.awt.*;

public class Ball extends Sprites {
    int dirX = 1;
    int dirY = 1;
    int diameter = lenX;

    Ball(int x, int y) {
        super(x, y, 30,30);
    }

    @Override
    public void draw(Graphics2D g) {
        g.fillOval(x, y, lenX, lenY);
    }


    public void move(int h, int w) {

        x += dirX;
        y += dirY;

        if ((y + lenY)  > h - diameter) {
            dirY = -1;

        } else if (y < 0) {
            dirY = 1;
        }

        if ((x + lenX) > w - diameter) {
            dirX = -1;

        } else if (x < 0) {
            dirX = 1;
        }

    }

    boolean collision(Bat b) {
        if (b.getBounds().intersects(getBounds())) {

        }
    }


}
