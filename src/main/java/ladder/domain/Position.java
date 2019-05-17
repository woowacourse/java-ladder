package ladder.domain;

public class Position {
    public static int MAX;
    public final int position;

    public Position(int position) {
        validateBiggerThanZero(position);
        validateNotBiggerThanMax(position);
        this.position = position;
    }

    private void validateBiggerThanZero(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("플레이어의 위치는 0보다 작을 수 없습니다.");
        }
    }

    private void validateNotBiggerThanMax(int position) {
        if (position > MAX) {
            throw new IllegalArgumentException("플레이어의 위치는 플레이어 수보다 작아야합니다.");
        }
    }
}
