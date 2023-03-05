package domain.player;

public class Position {

    private static final int MIN_POSITION = 0;

    private static final String UNDER_MIN_POSITION_MESSAGE = "위치는 " + MIN_POSITION + " 이하 일 수 없습니다.";

    private int position;

    public Position(final int position) {
        validatePosition(position);
        this.position = position;
    }

    public Position move(final int direction) {
        return new Position(this.position+direction);
    }

    private void validatePosition(final int position) {
        if (position < MIN_POSITION) {
            throw new IllegalArgumentException(UNDER_MIN_POSITION_MESSAGE);
        }
    }

    public int getPosition() {
        return this.position;
    }
}
