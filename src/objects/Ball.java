package objects;

import utils.Constants;

import java.awt.*;

/**
 * Created by Mason on 6/5/17.
 */
public class Ball extends GameObject {

    public Ball() {
        super(Constants.BOARD_WIDTH/2, Constants.BOARD_HEIGHT/2);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawRect(getX(), getY(), 5, 5);
        g.fillRect(getX(), getY(), 5, 5);
    }
}
