package domain;

public enum Stick {

    FILLED,
    NOT_FILLED;

    public boolean isFilled() {
        return this == FILLED;
    }
}
