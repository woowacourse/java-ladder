package ladder.domain;

public class Position {
    public static int MAX;
    public final int position;

    public Position(int position) {
        validateBiggerThanZero(position);
        this.position = position;
    }

    private void validateBiggerThanZero(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("플레이어의 위치는 0보다 작을 수 없습니다.");
        }
    }
}
