package utils;

import main.Game;

import java.awt.geom.Rectangle2D;

public class Helper {
    public static boolean CanMoveHere(float x, float y, float width, float height, int[][] levelData) {
        if (isSolid(x, y, levelData) || isSolid(x + width, y + height, levelData) || isSolid(x + width, y, levelData))
            return false;
        return !isSolid(x, y + height, levelData);
    }
    private static boolean isSolid(float x, float y, int[][] levelData) {
        if (x < 0 || x >= Game.GAME_WIDTH || y < 0 || y >= Game.GAME_HEIGHT) return true;

        float xIndex = x / Game.TILES_SIZE;
        float yIndex = y / Game.TILES_SIZE;
        int value = levelData[(int) yIndex][(int) xIndex];

        return value != 11;
    }
    public static float GetEntityXPosNextToWall(Rectangle2D.Float hitBox, float xSpeed) {
        int currentTile = (int) hitBox.x / Game.TILES_SIZE;
        if(xSpeed > 0) {
            int TileXPos = currentTile * Game.TILES_SIZE;
            int xOffset = (int) (Game.TILES_SIZE - hitBox.width);
            return TileXPos + xOffset - 1;
        } else {
            return currentTile * Game.TILES_SIZE;
        }
    }
    public static float GetEntityYPosNearRoofOrFloor(Rectangle2D.Float hitBox, float airSpeed) {
        int currentTile = (int) hitBox.y / Game.TILES_SIZE;
        if(airSpeed > 0) {
            int tileYPos = currentTile * Game.TILES_SIZE;
            int yOffset = (int) (Game.TILES_SIZE - hitBox.height);
            return tileYPos + yOffset - 1;
        } else {
            return currentTile * Game.TILES_SIZE;
        }
    }
    public static boolean IsEntityOnFloor(Rectangle2D.Float hitBox, int[][] levelData) {
        if(!isSolid(hitBox.x, hitBox.y + hitBox.height + 1, levelData )) {
            return isSolid(hitBox.x + hitBox.width, hitBox.y + hitBox.height + 1, levelData);
        }
        return true;
    }
}
