package domain.connection;

public enum Connection {

    LEFT_CONNECTION(-1),
    RIGHT_CONNECTION(1),
    DISCONNECTION(0);

    private final int moveWeight;

    Connection(int moveWeight) {
        this.moveWeight = moveWeight;
    }

    public int getMoveWeight() {
        return moveWeight;
    }
}
