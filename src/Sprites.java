import java.awt.*;

public class Sprites {

    public int x;
    public int y;
    final int X;
    final int Y;
    int lenX;
    int lenY;

    Sprites(int x, int y, int lenX, int lenY) {
        this.x = x;
        this.y = y;
        X = x;
        Y = y;
        this.lenX = lenX;
        this.lenY = lenY;

    }

    public void draw(Graphics2D g) {
        g.fillRect(x, y, lenX, lenY);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, lenX, lenY);
    }

}
