package ui;

import utils.LoadSave;
import static utils.Constants.UI.Buttons.Pause.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SoundButton extends PauseButton {
    private BufferedImage[][] soundImages;
    private boolean mouseOver, mousePressed;
    private boolean muted;
    private int rowIndex, colIndex;
    public SoundButton(int x, int y, int width, int height) {
        super(x, y, width, height);
        loadSoundImages();
    }

    private void loadSoundImages() {
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.SOUND_BUTTONS);
        soundImages = new BufferedImage[2][3];
        for (int i = 0; i < soundImages.length; i++) {
            for (int j = 0; j < soundImages[i].length; j++) {
                soundImages[i][j] = temp.getSubimage(j * SOUND_BUTTON_SIZE_DEFAULT, i * SOUND_BUTTON_SIZE_DEFAULT, SOUND_BUTTON_SIZE_DEFAULT, SOUND_BUTTON_SIZE_DEFAULT);
            }
        }
    }

    public void update() {
        if(muted) rowIndex = 0;
        else rowIndex = 1;
        colIndex = 0;
        if(mouseOver) colIndex = 1;
        if(mousePressed) colIndex = 2;
    }

    public void draw(Graphics g) {
        g.drawImage(soundImages[rowIndex][colIndex], x, y, width, height, null);
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

    public boolean isMuted() {
        return muted;
    }

    public void setMuted(boolean muted) {
        this.muted = muted;
    }

    public void resetBooleans() {
        mousePressed = false;
        mouseOver = false;
    }
}
