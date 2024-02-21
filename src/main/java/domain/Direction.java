package domain;

public enum Direction {
    LEFT,
    RIGHT,
    DOWN;

    public static Direction generate(boolean selector) {
        if (selector) {
            return RIGHT;
        }

        return DOWN;
    }
}
