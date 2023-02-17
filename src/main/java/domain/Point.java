package domain;

public enum Point {

    CONNECTION(true),
    SEPARATION(false);

    private final boolean status;

    Point(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public boolean isConnection() {
        return status;
    }
}
