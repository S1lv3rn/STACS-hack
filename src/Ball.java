import java.awt.*;

public class Ball extends Sprites {
    int dirX = 1;
    int dirY = 1;
    int score0 = 0;
    int score1 = 10;
    int score2 = 10;
    boolean pVp;

    Ball(int x, int y, boolean pVp) {
        super(x, y, 30,30);
        this.pVp = pVp;
    }

    @Override
    public void draw(Graphics2D g) {
        g.fillOval(x, y, lenX, lenY);
    }


    public void move(int h, int w) throws InterruptedException {

        x += dirX;
        y += dirY;

        if ((y + lenY)  > h) {
            dirY = -dirY;

        } else if (y < 0) {
            dirY = -dirY;
        }

        if ((x + lenX) > w) {

            if (pVp) {
                score2 -= 1;
            }

            x = w/2 + (lenX/2);
            y = h/2 + (lenY/2);
            Thread.sleep(100);



        } else if (x < 0) {

            if (pVp) {
                score1 -= 1;
            }

            x = w/2 + (lenX/2);
            y = h/2 + (lenY/2);
            Thread.sleep(100);

        }



    }

    void collision(Bat b) {
        if (b.getBounds().intersects(getBounds())) {
            dirX = -dirX;
            if (!pVp && (b.plr1 && x >= b.lenX || !b.plr1 && lenX <= b.x)) {
                score0 ++;
            }
        }
    }


    void reSet() {
        dirX = 1;
        dirY = 1;
        score0 = 0;
        score1 = 10;
        score2 = 10;
    }


}
