package domain;

public enum Bridge {
    EXIST(true),
    BLANK(false);

    private final boolean status;

    Bridge(boolean status) {
        this.status = status;
    }

    public boolean isExist() {
        return status;
    }
}
