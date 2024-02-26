package model;

public enum LadderStatus {

    CONNECTED(true),
    UNCONNECTED(false),
    ;

    private final boolean connectionInfo;

    LadderStatus(final boolean connectionInfo) {
        this.connectionInfo = connectionInfo;
    }

    public static LadderStatus from(boolean isConnected) {
        if (isConnected) {
            return CONNECTED;
        }
        return UNCONNECTED;
    }

    public boolean isConnected() {
        return this.connectionInfo;
    }
}
