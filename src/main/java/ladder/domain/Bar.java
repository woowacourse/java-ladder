package ladder.domain;

public enum Bar {
    MOVABLE,
    IMMOVABLE;

    public static Bar of(boolean isMovable) {
        if (isMovable) {
            return MOVABLE;
        }
        return IMMOVABLE;
    }

    public boolean isMovable() {
        return this == MOVABLE;
    }

    public boolean isImmovable() {
        return this == IMMOVABLE;
    }
}
