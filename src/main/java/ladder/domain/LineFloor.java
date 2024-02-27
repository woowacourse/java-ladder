package ladder.domain;

public class LineFloor {
    private static final int MINIMUM_LINE_FLOOR = 0;

    private final int value;

    public LineFloor(final int value) {
        validateLineFloor(value);
        this.value = value;
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
