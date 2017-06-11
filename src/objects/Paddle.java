package objects;

import java.awt.*;

/**
 * Created by Mason on 6/9/17.
 */
public class Paddle extends GameObject {

    public Paddle(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(getX(), getY(), 5, 25);
    }
}
