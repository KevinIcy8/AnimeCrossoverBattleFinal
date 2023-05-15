package Test;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame test = new JFrame();
        test.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        test.setResizable(false);
        test.setTitle("Main");

        GamePanel gamePanel = new GamePanel();
        test.add(gamePanel);
        test.pack();

        test.setLocationRelativeTo(null);
        test.setVisible(true);
        gamePanel.startGameThread();

    }
}