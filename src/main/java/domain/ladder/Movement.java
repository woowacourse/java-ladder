package domain.ladder;

public enum Movement {
    GO_RIGHT(1),
    GO_LEFT(-1),
    STAY(0);

    private final int movement;

    Movement(int movement) {
        this.movement = movement;
    }

    public int move(int index) {
        return index + movement;
    }
}
