package ladder.domain;

public class Location {
    private final int MINIMUM_INDEX = 0;

    private int columnIndex;

    public Location(int columnIndex) {
        validateStartColumnIndex(columnIndex);
        this.columnIndex = columnIndex;
    }

    public int getColumnIndex() {
        return this.columnIndex;
    }

    public void moveColumnTo(Direction direction) {
        this.columnIndex += direction.getIndexDifference();
    }

    private void validateStartColumnIndex(int startColumnIndex) {
        if (startColumnIndex < MINIMUM_INDEX) {
            throw new IllegalArgumentException(String.format("시작 위치는 %d 이상이어야 합니다.", MINIMUM_INDEX));
        }
    }
}
