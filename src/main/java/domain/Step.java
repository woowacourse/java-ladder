package domain;

public enum Step {
    NONE(0),
    LEFT(-1),
    RIGHT(1);

    private final int moveDirection;

    Step(final int movePosition) {
        this.moveDirection = movePosition;
    }

    public boolean isRightConnection() {
        return this == RIGHT;
    }

    public static Step getRandomValidStep(boolean rightStepFlag) {
        if (rightStepFlag) {
            return Step.RIGHT;
        }

        return Step.NONE;
    }

    public int move(int currentPosition) {
        return this.moveDirection + currentPosition;
    }
}
