package ladder.domain;

public class LineFloor {
    private static final int MINIMUM_LINE_FLOOR = 0;

    private final int lineFloor;

    public LineFloor(final int lineFloor) {
        validateLineFloor(lineFloor);
        this.lineFloor = lineFloor;
    }

    private static void validateLineFloor(final int lineFloor) {
        if (lineFloor < MINIMUM_LINE_FLOOR) {
            throw new IllegalArgumentException("유효하지 않은 라인 층 번호입니다.");
        }
    }
}
