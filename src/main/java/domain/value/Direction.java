package domain.value;

public enum Direction {

    // Direction 에서 더해질 값을 가지고 있기 VS
    // Position 에서 더해질 값을 지정하기 (Map 등에 저장하기)
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
