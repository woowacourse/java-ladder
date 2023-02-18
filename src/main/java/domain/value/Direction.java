package domain.value;

public enum Direction {

    // Direction 에서 더해질 값을 가지고 있기 VS
    // Position 에서 더해질 값을 지정하기 (Map 등에 저장하기)
    LEFT(-1),
    RIGHT(1),
    NONE(0),
    ;

    private final int moveAmount;

    Direction(final int moveAmount) {
        this.moveAmount = moveAmount;
    }

    public int move(final int position) {
        return position + moveAmount;
    }
}
