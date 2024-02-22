package ladder.constant;

public enum LadderPath {
    STAY, LEFT, RIGHT;

    public boolean isRightPath() {
        return this == RIGHT;
    }
}
