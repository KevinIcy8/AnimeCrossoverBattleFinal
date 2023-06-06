package Test;

public class Constants {
    public static class Directions{
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;
    }
    public static class PlayerConstants{
        public static final int IDLE = 0;

        public static final int RUNNING = 1;

        public static final int JUMP = 2;
        public static final int GROUND = 3;
        public static final int HIT = 4;
        public static final int BASIC_ATK = 5;
        public static final int SPECIAL_ATK = 6;
        public static final int ULTI = 7;

        public static int GetSpriteAmount(int playerAction){
            switch(playerAction) {
                case RUNNING:
                    return 6;
                case IDLE:
                    return 4;
                case JUMP:
                    //return 6;
                case GROUND:
                    //return 6;
                case HIT:
                    //return 6;
                case BASIC_ATK:
                    return 5;
                case SPECIAL_ATK:
                    return 3;
                case ULTI:
                    return 7;
                default:
                    return 1;
            }
        }
    }

}
