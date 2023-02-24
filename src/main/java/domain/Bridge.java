package domain;

public enum Bridge {
    EXIST,
    EMPTY;

    public static Bridge from(boolean status) {
        if (status) {
            return EXIST;
        }
        return EMPTY;
    }

    public boolean isExist() {
        return this == EXIST;
    }
}
