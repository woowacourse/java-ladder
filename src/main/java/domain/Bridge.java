package domain;

public enum Bridge {
    EXIST,
    BLANK;

    public boolean isExist() {
        return this == EXIST;
    }

    public boolean isNotExist() {
        return this == BLANK;
    }
}
