package domain;

public enum Direction {

    LEFT(-1),
    RIGHT(1),
    STAY(0);

    private final int moveWeight;

    Direction(int moveWeight) {
        this.moveWeight = moveWeight;
    }

    public int getMoveWeight() {
        return moveWeight;
    }
}
