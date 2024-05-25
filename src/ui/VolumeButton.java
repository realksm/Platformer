package ui;

import utils.LoadSave;

import static utils.Constants.UI.Buttons.Volume.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class VolumeButton extends PauseButton {
    private BufferedImage[] images;
    private BufferedImage slider;
    private int index;
    private boolean mouseOver, mousePressed;
    private int buttonX;
    private final int minX;
    private final int maxX;

    public VolumeButton(int x, int y, int width, int height) {
        super(x + width / 2, y, VOLUME_BUTTON_WIDTH, height);
        bounds.x -= VOLUME_BUTTON_WIDTH / 2;
        buttonX = x + width / 2;
        this.x = x;
        this.width = width;
        minX = x + VOLUME_BUTTON_WIDTH / 2;
        maxX = x + width - VOLUME_BUTTON_WIDTH / 2;
        loadImages();
    }

    private void loadImages() {
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.VOLUME_BUTTONS);
        images = new BufferedImage[3];

        images[0] = temp.getSubimage(0, 0, VOLUME_BUTTON_DEFAULT_WIDTH, VOLUME_BUTTON_DEFAULT_HEIGHT);
        images[1] = temp.getSubimage(VOLUME_BUTTON_DEFAULT_WIDTH, 0, VOLUME_BUTTON_DEFAULT_WIDTH, VOLUME_BUTTON_DEFAULT_HEIGHT);
        images[2] = temp.getSubimage(2 * VOLUME_BUTTON_DEFAULT_WIDTH, 0, VOLUME_BUTTON_DEFAULT_WIDTH, VOLUME_BUTTON_DEFAULT_HEIGHT);

        slider = temp.getSubimage(3 * VOLUME_BUTTON_DEFAULT_WIDTH, 0, SLIDER_DEFAULT_WIDTH, VOLUME_BUTTON_DEFAULT_HEIGHT);
    }

    public void update() {
        index = 0;
        if (mouseOver) index = 1;
        if (mousePressed) index = 2;
    }

    public void draw(Graphics g) {
        g.drawImage(slider, x, y, width, height, null);
        g.drawImage(images[index], buttonX - VOLUME_BUTTON_WIDTH / 2, y, VOLUME_BUTTON_WIDTH, height, null);
    }

    public void changeX(int x) {
        if (x < minX) buttonX = minX;
        else buttonX = Math.min(x, maxX);

        bounds.x = buttonX - VOLUME_BUTTON_WIDTH / 2;
    }

    public void resetBooleans() {
        mousePressed = false;
        mouseOver = false;
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
}
