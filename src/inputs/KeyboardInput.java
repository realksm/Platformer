package inputs;

import gamestates.Gamestate;
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
        switch (Gamestate.state) {
            case PLAYING -> gamePanel.getGame().getPlaying().keyPressed(e);
            case MENU -> gamePanel.getGame().getMenu().keyPressed(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (Gamestate.state) {
            case PLAYING -> gamePanel.getGame().getPlaying().keyReleased(e);
            case MENU -> gamePanel.getGame().getMenu().keyReleased(e);
        }
    }
}
