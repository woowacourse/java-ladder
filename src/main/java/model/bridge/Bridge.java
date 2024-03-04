package model.bridge;

public enum Bridge {
    CONNECTED(1),
    UNCONNECTED(0);

    private final int movement;

    Bridge(int movement) {
        this.movement = movement;
    }

    public int moveRight(int position) {
        return position + movement;
    }

    public int moveLeft(int position) {
        return position - movement;
    }

    public boolean isConnected() {
        return this == CONNECTED;
    }

    public boolean isUnconnected() {
        return this == UNCONNECTED;
    }
}
