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

    public static boolean isPathExist(LadderPath leftPath, LadderPath rightPath) {
        return leftPath.equals(RIGHT) && rightPath.equals(LEFT);
    }

    public boolean isConnected() {
        return connected;
    }
}
