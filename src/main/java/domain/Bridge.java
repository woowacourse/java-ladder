package domain;

public enum Bridge {
    EXIST,
    BLANK;

    public boolean isExist() {
        return this == EXIST;
    }
}
