package domain.ladder;

public enum Step {
    NONE, LEFT, RIGHT;

    public static Step makeRandom(boolean isConnectedToRight) {
        if (isConnectedToRight) {
            return Step.RIGHT;
        }
        return Step.NONE;
    }

    public static Step makeLeft() {
        return Step.LEFT;
    }

    public boolean isConnectedToRight() {
        return this == Step.RIGHT;
    }
}
