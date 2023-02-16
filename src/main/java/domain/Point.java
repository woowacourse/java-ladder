package domain;

public enum Point {

    CONNECTION(true),
    SEPARATION(false);

    private static final String FORMATTED_DASH = "-----";
    private static final String FORMATTED_BLANK = "     ";
    private static final String DIVIDER = "|";

    private boolean status;

    Point(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public String toFormattedStatus() {
        if (status) {
            return FORMATTED_DASH + DIVIDER;
        }
        return FORMATTED_BLANK + DIVIDER;
    }
}
