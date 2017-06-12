package objects;

import utils.Constants;

import java.awt.*;

/**
 * Created by Mason on 6/9/17.
 */
public class Paddle extends GameObject {

    public Paddle(int x, int y) {
        super(x, y, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT);
    }
}
