package ui;

import utils.Constants;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mason on 6/5/17.
 */
public class MainScreen extends JFrame {

    public MainScreen() {
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        setLayout(new GridLayout());
        add(new GameView());
        setTitle("Pong");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
