package ui;

import gamestates.Gamestate;
import utils.LoadSave;
import static utils.Constants.UI.Buttons.Menu.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MenuButton {
    private final int xPos;
    private final int yPos;
    private final int rowIndex;
    private int index;
    private final int xOffsetCenter = MENU_BUTTON_WIDTH / 2;
    private boolean mouseOver, mousePressed;
    private final Gamestate state;
    private BufferedImage[] images;
    private Rectangle bounds;
    public MenuButton(int xPos, int yPos, int rowIndex, Gamestate state) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.rowIndex = rowIndex;
        this.state = state;
        loadImages();
        init();
    }
    public void init() {
        bounds = new Rectangle(xPos - xOffsetCenter, yPos, MENU_BUTTON_WIDTH, MENU_BUTTON_HEIGHT);
    }
    private void loadImages() {
        images = new BufferedImage[3];
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.MENU_BUTTONS);
        for (int i = 0; i < images.length; i++) {
            images[i] = temp.getSubimage(i * MENU_BUTTON_WIDTH_DEFAULT, rowIndex * MENU_BUTTON_HEIGHT_DEFAULT, MENU_BUTTON_WIDTH_DEFAULT, MENU_BUTTON_HEIGHT_DEFAULT);
        }
    }
    public void draw(Graphics g) {
        g.drawImage(images[index], xPos - xOffsetCenter, yPos, MENU_BUTTON_WIDTH, MENU_BUTTON_HEIGHT, null);
    }
    public void update() {
        index = 0;
        if(mouseOver) index = 1;
        if(mousePressed) index = 2;
    }
    public void applyGamestate() {
        Gamestate.state = state;
    }
    public boolean isMouseOver() {
        return mouseOver;
    }
    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }
    public boolean isMousePressed() {
        return mousePressed;
    }
    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }
    public void resetBooleans() {
        this.mouseOver = false;
        this.mousePressed = false;
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
