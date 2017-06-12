package ui;

import com.sun.tools.internal.jxc.ap.Const;
import objects.Ball;
import objects.Paddle;
import utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GameView extends JPanel implements ActionListener {

    Ball ball;
    Paddle paddleOne;
    Paddle paddleTwo;
    Timer timer;
    int ballDx = 2;
    int ballDy = 2;
    int paddleOneScore = 0;
    int paddleTwoScore = 0;

    boolean movePaddleOneUp = false;
    boolean movePaddleOneDown = false;


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawLine(Constants.BOARD_WIDTH/2, 0, Constants.BOARD_WIDTH/2, Constants.BOARD_HEIGHT);
        g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 32));
        g.drawString(Integer.toString(paddleOneScore), Constants.BOARD_WIDTH/4, 50);
        g.drawString(Integer.toString(paddleTwoScore), 3 * Constants.BOARD_WIDTH/4, 50);
        ball.draw(g);
        paddleOne.draw(g);
        paddleTwo.draw(g);
    }


    public GameView() {
        setFocusable(true);
        setSize(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT);
        setBackground(Color.black);
        addKeyListener(new Adapter());
        resetBall();
        paddleOne = new Paddle(Constants.PADDLE_OFFSET, Constants.BOARD_HEIGHT/2);
        paddleTwo = new Paddle(Constants.BOARD_WIDTH - Constants.PADDLE_OFFSET, Constants.BOARD_HEIGHT/2);
        timer = new Timer(Constants.DELAY, this);
        timer.start();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        checkPaddleCollision();
        handleBallMovement();
        handlePaddleMovement();
        repaint();
    }

    public void resetBall() {
        ball = new Ball();
    }

    public void checkPaddleCollision() {
        if(ball.isIntersecting(paddleOne) || ball.isIntersecting(paddleTwo)) {
            ballDx *= -1;
        }
    }

    public void handlePaddleMovement() {
        if(!paddleOne.getRectangle().intersectsLine(0, 0, Constants.BOARD_WIDTH, 0) && movePaddleOneUp) {
            paddleOne.moveVertically(-2);
        }
        if(!paddleOne.getRectangle().intersectsLine(0, Constants.BOARD_HEIGHT, Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT) && movePaddleOneDown) {
            paddleOne.moveVertically(2);
        }
    }

    public void handleBallMovement() {
        if(ball.getX() <= Constants.BOARD_WIDTH && ball.getY() <= Constants.BOARD_HEIGHT) {
            if(ball.getRectangle().intersectsLine(0, 0, 0, Constants.BOARD_HEIGHT)) {
                ++paddleTwoScore;
                resetBall();
                ballDx *= -1;
            }
            if(ball.getRectangle().intersectsLine(Constants.BOARD_WIDTH, 0, Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT)) {
                ++paddleOneScore;
                resetBall();
                ballDx *= -1;
            }
            if(ball.getRectangle().intersectsLine(0, Constants.BOARD_HEIGHT, Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT)
                    || ball.getRectangle().intersectsLine(0, 0, Constants.BOARD_WIDTH, 0)) ballDy *= -1;
            ball.move(ballDx, ballDy);
        }
    }

    public class Adapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent event) {
            if(event.getKeyCode() == KeyEvent.VK_UP) {
                movePaddleOneUp = true;
            }
            if(event.getKeyCode() == KeyEvent.VK_DOWN) {
                movePaddleOneDown = true;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
                movePaddleOneUp = false;
                movePaddleOneDown = false;
            }
        }
    }
}
