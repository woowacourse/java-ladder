package ladder.constant;

public enum LadderPath {
    STAY, LEFT, RIGHT;

    public boolean isRightPath() {
        return this == RIGHT;
    }

    public boolean isNotRightPath() {
        return this != RIGHT;
    }

    public boolean isLeftPath() {
        return this == LEFT;
    }

    public boolean isNotLeftPath() {
        return this != LEFT;
    }
}
