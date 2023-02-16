package ladder.domain;

enum Leg {
    CONNECT(true),
    EMPTY(false);
    private final boolean isConnected;

    Leg(boolean isConnected) {
        this.isConnected = isConnected;
    }

    boolean getIsConnected() {
        return isConnected;
    }
}
