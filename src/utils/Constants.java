package utils;

import main.Game;

public class Constants {
    public static class UI {
        public static class Buttons {
            public static class Menu {
                public static final int MENU_BUTTON_WIDTH_DEFAULT = 140;
                public static final int MENU_BUTTON_HEIGHT_DEFAULT = 56;
                public static final int MENU_BUTTON_WIDTH = (int) (MENU_BUTTON_WIDTH_DEFAULT * Game.SCALE);
                public static final int MENU_BUTTON_HEIGHT = (int) (MENU_BUTTON_HEIGHT_DEFAULT * Game.SCALE);
            }
            public static class Pause {
                public static final int SOUND_BUTTON_SIZE_DEFAULT = 42;
                public static final int SOUND_BUTTON_SIZE = (int) (SOUND_BUTTON_SIZE_DEFAULT * Game.SCALE);
            }
            public static class URM {
                public static final int URM_BUTTON_DEFAULT_SIZE = 56;
                public static final int URM_BUTTON_SIZE = (int) (URM_BUTTON_DEFAULT_SIZE * Game.SCALE);
            }
            public static class Volume {
                public static final int VOLUME_BUTTON_DEFAULT_WIDTH = 28;
                public static final int VOLUME_BUTTON_DEFAULT_HEIGHT = 44;
                public static final int SLIDER_DEFAULT_WIDTH = 215;
                public static final int VOLUME_BUTTON_WIDTH = (int) (VOLUME_BUTTON_DEFAULT_WIDTH * Game.SCALE);
                public static final int VOLUME_BUTTON_HEIGHT = (int) (VOLUME_BUTTON_DEFAULT_HEIGHT * Game.SCALE);
                public static final int SLIDER_WIDTH = (int) (SLIDER_DEFAULT_WIDTH * Game.SCALE);
            }
        }
    }
    public static class Directions {
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;
    }
    public static class PlayerConstants {
        public static final int IDLE = 0;
        public static final int RUNNING = 1;
        public static final int JUMP = 2;
        public static final int FALLING = 3;
        public static final int GROUND = 4;
        public static final int HIT = 5;
        public static final int ATTACK_1 = 6;
        public static final int ATTACK_JUMP_1 = 7;
        public static final int ATTACK_JUMP_2 = 8;
        public static int GetSpriteAmount(int playerAction) {
            return switch (playerAction) {
                case RUNNING -> 6;
                case IDLE -> 5;
                case HIT -> 4;
                case JUMP, ATTACK_1, ATTACK_JUMP_1, ATTACK_JUMP_2 -> 3;
                case GROUND -> 2;
                case FALLING -> 1;
                default -> 1;
            };
        }
    }
}