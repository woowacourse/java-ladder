package model;

public enum Space {
    LINE(true),
    EMPTY(false);

    private final boolean value;

    Space(boolean value) {
        this.value = value;
    }

    public static Space of(boolean value) {
        if (value) {
            return Space.LINE;
        }
        return Space.EMPTY;
    }

    public boolean isValue() {
        return value;
    }
}
