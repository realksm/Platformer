package gamestates;

import main.Game;
import ui.MenuButton;
import utils.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Menu extends State implements StateMethods {
    private MenuButton[] buttons = new MenuButton[3];
    private BufferedImage backgroundImage;
    private int menuX, menuY, menuWidth, menuHeight;
    public Menu(Game game) {
        super(game);
        loadButtons();
        loadBackground();
    }

    private void loadBackground() {
        backgroundImage = LoadSave.GetSpriteAtlas(LoadSave.MENU_BACKGROUND);
        menuWidth = (int) (backgroundImage.getWidth() * Game.SCALE);
        menuHeight = (int) (backgroundImage.getHeight() * Game.SCALE);
        menuX = (Game.GAME_WIDTH / 2) - (menuWidth / 2);
        menuY = (int) (45 * Game.SCALE);
    }

    private void loadButtons() {
        buttons[0] = new MenuButton(Game.GAME_WIDTH / 2, (int) (150 * Game.SCALE), 0, Gamestate.PLAYING);
        buttons[1] = new MenuButton(Game.GAME_WIDTH / 2, (int) (220 * Game.SCALE), 1, Gamestate.OPTIONS);
        buttons[2] = new MenuButton(Game.GAME_WIDTH / 2, (int) (290 * Game.SCALE), 2, Gamestate.EXIT);
    }

    @Override
    public void update() {
        for (MenuButton button : buttons) button.update();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(backgroundImage, menuX, menuY, menuWidth, menuHeight, null);
        for (MenuButton button : buttons) button.draw(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (MenuButton button : buttons) {
            if(isIn(e, button)) {
                button.setMousePressed(true);
                break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for (MenuButton button : buttons)
            if (isIn(e, button)) {
                if (button.isMousePressed()) button.applyGamestate();
                break;
            }
        resetButtons();
    }

    private void resetButtons() {
        for (MenuButton button : buttons) button.resetBooleans();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for (MenuButton button : buttons) button.setMouseOver(false);

        for (MenuButton button : buttons)
            if(isIn(e, button)) {
                button.setMouseOver(true);
                break;
            }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) Gamestate.state = Gamestate.PLAYING;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
