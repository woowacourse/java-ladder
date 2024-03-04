package domain.ladder;

public enum DirectionalPoint {
    LEFT(-1),
    STRAIGHT(0),
    RIGHT(1);

    private final int direction;

    DirectionalPoint(final int direction) {
        this.direction = direction;
    }

    public static DirectionalPoint findDirectionalPoint(final boolean isConnected) {
        if (isConnected) {
            return RIGHT;
        }
        return STRAIGHT;
    }

    public int getDirection() {
        return direction;
    }
}
