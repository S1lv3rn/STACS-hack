import java.awt.*;

public class Sprites {

    public int x;
    public int y;
    public int lenX;
    public int lenY;

    Sprites(int lenX, int lenY) {
        this.lenX = lenX;
        this.lenY = lenY;
    }

    public void draw(Graphics2D g) {
        g.fillRect(x, y, lenX, lenY);
    }
}
