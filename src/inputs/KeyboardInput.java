package inputs;

import main.GamePanel;
import static utils.Constants.Directions.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener {

    GamePanel gamePanel;
    public KeyboardInput(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> gamePanel.getGame().getPlayer().setUp(true);
            case KeyEvent.VK_A -> gamePanel.getGame().getPlayer().setLeft(true);
            case KeyEvent.VK_S -> gamePanel.getGame().getPlayer().setDown(true);
            case KeyEvent.VK_D -> gamePanel.getGame().getPlayer().setRight(true);
            case KeyEvent.VK_SPACE -> gamePanel.getGame().getPlayer().setJump(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> gamePanel.getGame().getPlayer().setUp(false);
            case KeyEvent.VK_A -> gamePanel.getGame().getPlayer().setLeft(false);
            case KeyEvent.VK_S -> gamePanel.getGame().getPlayer().setDown(false);
            case KeyEvent.VK_D -> gamePanel.getGame().getPlayer().setRight(false);
            case KeyEvent.VK_SPACE -> gamePanel.getGame().getPlayer().setJump(false);
        }
    }
}
