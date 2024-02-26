package domain.ladder;

public enum DirectionalRung {
    LEFT(-1),
    MID(0),
    RIGHT(1);

    private final int direction;

    DirectionalRung(final int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }
}
