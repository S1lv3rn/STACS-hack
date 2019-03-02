import java.awt.*;

public class Bat extends Sprites {

    private int speed = 10;

    Bat(int x, int y) {
        super(x, y,20, 70);
    }

    public void goUp() {

        if (!(y < 0)) {
            y -= speed;
        }
    }

    public void goDown(int h) {

        if (!(y > h)) {
            y += speed;
        }
    }
}
