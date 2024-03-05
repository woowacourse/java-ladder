package ladder.domain.direction;

public enum Direction {

    RIGHT,
    NEUTRAL,
    LEFT;

    public static Direction getDirection(boolean isRight) {
        if (isRight) {
            return RIGHT;
        }
        return NEUTRAL;
    }
}
