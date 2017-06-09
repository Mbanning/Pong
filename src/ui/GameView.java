package ui;

import com.sun.tools.internal.jxc.ap.Const;
import objects.Ball;
import utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mason on 6/5/17.
 */
public class GameView extends JPanel implements ActionListener {

    Ball ball;
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
    }


    public GameView() {
        setSize(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT);
        setBackground(Color.black);
        ball = new Ball();
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

}
