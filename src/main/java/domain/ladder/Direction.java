package domain.ladder;

public enum Direction {

    STRAIGHT_DOWN(0),
    LEFT_DOWN(-1),
    RIGHT_DOWN(1);

    private final int lineMovement;

    Direction(int lineMovement) {
        this.lineMovement = lineMovement;
    }

    public int getLineMovement() {
        return lineMovement;
    }
}
