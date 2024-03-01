package ladderGame.model;

public enum ConnectionStatus {
    CONNECTION,
    DISCONNECTION;

    public static ConnectionStatus of(boolean flag) {
        if (flag) {
            return CONNECTION;
        }
        return DISCONNECTION;
    }
}
