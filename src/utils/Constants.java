package utils;

public class Constants {
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