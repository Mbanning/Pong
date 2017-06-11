package ui;

import com.sun.tools.internal.jxc.ap.Const;
import javafx.scene.input.KeyCode;
import objects.Ball;
import objects.Paddle;
import utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Mason on 6/5/17.
 */
public class GameView extends JPanel implements ActionListener {

    Ball ball;
    Paddle paddleOne;
    Paddle paddleTwo;
    Timer timer;
    int ballDx = 2;
    int ballDy = 2;


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawLine(Constants.BOARD_WIDTH/2, 0, Constants.BOARD_WIDTH/2, Constants.BOARD_HEIGHT);
        g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 32));
        g.drawString("1", Constants.BOARD_WIDTH/4, 50);
        ball.draw(g);
        paddleOne.draw(g);
        paddleTwo.draw(g);
    }


    public GameView() {
        setFocusable(true);
        setSize(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT);
        setBackground(Color.black);
        addKeyListener(new Adapter());
        ball = new Ball();
        paddleOne = new Paddle(20, 20);
        paddleTwo = new Paddle(Constants.BOARD_WIDTH - 20, 20);
        timer = new Timer(Constants.DELAY, this);
        timer.start();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(ball.getX() <= Constants.BOARD_WIDTH && ball.getY() <= Constants.BOARD_HEIGHT) {
            if(ball.getX() >= Constants.BOARD_WIDTH - 5 || ball.getX() <= 0) ballDx *= -1;
            if(ball.getY() >= (Constants.BOARD_HEIGHT - 25) || ball.getY() <= 0) ballDy *= -1;
            ball.move(ballDx, ballDy);
        }
        repaint();
    }

    public class Adapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent event) {
            System.out.println(event.toString());
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println(e.toString());
        }
    }
}
