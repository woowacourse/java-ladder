package domain.model.ladder;

public enum Direction {
    LEFT(-1),
    RIGHT(1),
    NONE(0);

    private int movementOfIndex;

    Direction(int movementOfIndex) {
        this.movementOfIndex = movementOfIndex;
    }

    public int getMovementOfIndex() {
        return movementOfIndex;
    }
}
