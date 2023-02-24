package domain.ladder;

public enum Step {
    NONE, LEFT, RIGHT;

    public static Step makeWithRightCondition(boolean isConnectedToRight) {
        if (isConnectedToRight) {
            return Step.RIGHT;
        }
        return Step.NONE;
    }

    public boolean isConnectedToRight() {
        return this == Step.RIGHT;
    }

    public boolean isConnectedToLeft() {
        return this == Step.LEFT;
    }
}
