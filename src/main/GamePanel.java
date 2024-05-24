package main;

import inputs.KeyboardInput;
import inputs.MouseInput;
import javax.swing.*;
import java.awt.*;

import static main.Game.*;
public class GamePanel extends JPanel {
    private Game game;
    private MouseInput mouseInput;
    public GamePanel(Game game) {
        this.game = game;
        mouseInput = new MouseInput(this);
        setPanelSize();
        addKeyListener(new KeyboardInput(this));
        addMouseListener(mouseInput);
        addMouseMotionListener(mouseInput);
    }
    public void updateGame() {
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.render(g);
    }
    private void setPanelSize() {
        Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
        setPreferredSize(size);
        System.out.println("Game WIDTH : " + GAME_WIDTH + " | Game HEIGHT : " + GAME_HEIGHT);
    }
    public Game getGame() {
        return game;
    }
}