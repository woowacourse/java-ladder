package domain;

public enum Bridge {
    EXIST(true),
    EMPTY(false);

    private final boolean status;

    Bridge(boolean generateResult) {
        this.status = generateResult;
    }

    public static Bridge from(boolean status) {
        if (status) {
            return EXIST;
        }
        return EMPTY;
    }

    public boolean getStatus() {
        return status;
    }
}
