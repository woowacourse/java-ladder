package domain;

public enum ConnectStatus {
    CONNECT(true), DISCONNECT(false);

    private final boolean status;

    ConnectStatus(boolean status) {
        this.status = status;
    }

    public static ConnectStatus valueOf(boolean status) {
        if (status) {
            return CONNECT;
        }
        return DISCONNECT;
    }

    public boolean status() {
        return this.status;
    }
}
