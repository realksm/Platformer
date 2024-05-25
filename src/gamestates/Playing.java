package gamestates;

import entities.Player;
import levels.LevelManager;
import main.Game;
import ui.PauseOverlay;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Playing extends State implements StateMethods {
    private Player player;
    private LevelManager levelManager;
    private PauseOverlay pauseOverlay;
    private boolean paused = false;

    public Playing(Game game) {
        super(game);
        init();
    }

    private void init() {
        levelManager = new LevelManager(game);
        player = new Player(200, 200, (int) (64 * Game.SCALE), (int) (40 * Game.SCALE));
        player.loadLevelData(levelManager.getCurrentLevel().getLevelData());
        pauseOverlay = new PauseOverlay(this);
    }

    public Player getPlayer() {
        return player;
    }

    public void windowFocusLost() {
        player.resetBooleans();
    }

    @Override
    public void update() {
        if (!paused) {
            levelManager.update();
            player.update();
        } else {
            pauseOverlay.update();
        }
    }

    @Override
    public void draw(Graphics g) {
        levelManager.draw(g);
        player.render(g);
        if (paused) pauseOverlay.draw(g);
    }

    public void unpauseGame() {
        paused = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) player.setAttack(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (paused) pauseOverlay.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (paused) pauseOverlay.mouseReleased(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (paused) pauseOverlay.mouseMoved(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> player.setUp(true);
            case KeyEvent.VK_A -> player.setLeft(true);
            case KeyEvent.VK_S -> player.setDown(true);
            case KeyEvent.VK_D -> player.setRight(true);
            case KeyEvent.VK_SPACE -> player.setJump(true);
            case KeyEvent.VK_ESCAPE -> paused = !paused;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> player.setUp(false);
            case KeyEvent.VK_A -> player.setLeft(false);
            case KeyEvent.VK_S -> player.setDown(false);
            case KeyEvent.VK_D -> player.setRight(false);
            case KeyEvent.VK_SPACE -> player.setJump(false);
        }
    }

    public void mouseDragged(MouseEvent e) {
        if(paused) pauseOverlay.mouseDragged(e);
    }
}
