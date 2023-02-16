package domain;

public enum Point {
    CONNECTION(true),
    SEPARATION(false);

    private boolean status;
    Point(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public String toFormattedStatus() {
        if (status) {
            return "-----|";
        }
        return "     |";
    }
}
