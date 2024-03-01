package domain;

public enum Connection {
    LEFT_CONNECTED(Boolean.TRUE, Direction.LEFT),
    RIGHT_CONNECTED(Boolean.TRUE, Direction.RIGHT),
    DISCONNECTED(Boolean.FALSE, Direction.STAY);

    private final boolean connect;
    private final Direction direction;

    Connection(boolean connect, Direction direction) {
        this.connect = connect;
        this.direction = direction;
    }

    public boolean isConnect() {
        return connect;
    }

    public Direction getDirection() {
        return direction;
    }
}
