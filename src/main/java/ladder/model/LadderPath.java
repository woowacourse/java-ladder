package ladder.model;

public enum LadderPath {
    LEFT(true, -1),
    STAY(false, 0),
    RIGHT(true, 1);

    final boolean connected;
    final int direction;

    LadderPath(boolean connected, int direction) {
        this.connected = connected;
        this.direction = direction;
    }

    public static boolean isPathExist(LadderPath p1, LadderPath p2) {
        return p1.isConnected() && p2.isConnected();
    }

    public boolean isConnected() {
        return connected;
    }
}
