package domain;

public enum Point {
    CONNECTION(true),
    SEPARATION(false);

    private boolean status;
    Point(boolean status) {
        this.status = status;
    }

    public String toFormattedStatus() {
        if (status) {
            return "-----";
        }
        return "     ";
    }
}
