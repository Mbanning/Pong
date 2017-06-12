package objects;

import java.awt.*;

/**
 * Created by Mason on 6/5/17.
 */
public abstract class GameObject {

    private Rectangle object;


    public GameObject(int x, int y, int width, int height) {
         object = new Rectangle(x, y, width, height);
    }

    public void move(int dx, int dy) {
        object.translate(dx, dy);
    }

    public Rectangle getRectangle() {
        return object;
    }

    public double getX() {
        return object.getX();
    }

    public double getY() {
        return object.getY();
    }

    public void moveHorizontally(int dx) {
        move(dx, 0);
    }

    public void moveVertically(int dy) {
        move(0, dy);
    }

    public boolean isIntersecting(GameObject object) {
        return this.object.intersects(object.getRectangle());
    }

    public void draw(Graphics g) {
        g.fillRect((int) object.getX(),(int) object.getY(),(int) object.getWidth(),(int) object.getHeight());
    }
}
