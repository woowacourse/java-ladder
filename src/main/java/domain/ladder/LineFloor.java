package domain.ladder;

public record LineFloor(int value) {
    private static final int MINIMUM_LINE_FLOOR = 0;

    public LineFloor {
        validateLineFloor(value);
    }

    private static void validateLineFloor(final int lineFloor) {
        if (lineFloor < MINIMUM_LINE_FLOOR) {
            throw new IllegalArgumentException("유효하지 않은 라인 층 번호입니다.");
        }
    }

    public boolean isZero() {
        return value == 0;
    }
}
