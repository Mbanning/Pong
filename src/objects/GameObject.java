package objects;

import java.awt.*;

/**
 * Created by Mason on 6/5/17.
 */
public abstract class GameObject {

    private int x;
    private int y;

    public GameObject() {
        this(0, 0);
    }

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveHorizontally(int dx) {
        move(dx, 0);
    }

    public void moveVertically(int dy) {
        move(0, dy);
    }

    public abstract void draw(Graphics g);
}
