package domain.player;

public enum Movement {
    GO_RIGHT(1),
    GO_LEFT(-1),
    STAY(0);

    private final int movement;

    Movement(int movement) {
        this.movement = movement;
    }

    public Position move(Position position) {
        return new Position(position.getValue() + movement);
    }
}
