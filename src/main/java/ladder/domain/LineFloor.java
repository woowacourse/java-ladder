package ladder.domain;

public class LineFloor {

    private final int lineFloor;

    public LineFloor(final int lineFloor) {
        if (lineFloor < 1) {
            throw new IllegalArgumentException("유효하지 않은 라인 층 번호입니다.");
        }
        this.lineFloor = lineFloor;
    }
}
