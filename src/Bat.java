
public class Bat extends Sprites {

    private int speed = 10;
    boolean plr1;

    Bat(int x, int y, boolean plr1) {
        super(x, y,20, 70);
        this.plr1 = plr1;
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
