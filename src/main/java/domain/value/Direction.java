package domain.value;

public enum Direction {

    LEFT(-1),
    RIGHT(1),
    NONE(0),
    ;

    private final int sign;

    Direction(final int sign) {
        this.sign = sign;
    }

    public int sign(final int value) {
        return sign * value;
    }
}
