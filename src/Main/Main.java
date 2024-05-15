package Main;

import javax.swing.*;

public class Main {
    public static JFrame window;

    public static void main(String[] args) {
        window = new JFrame();

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.setTitle("Fishing with Piece");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setUndecorated(true);    //remove top bar

        window.pack();
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setUpGame();
        gamePanel.startGameThread();
    }
}