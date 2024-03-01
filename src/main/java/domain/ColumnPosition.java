package domain;

public class ColumnPosition {

    private static final int MIN = 0;
    private final int columnPosition;

    public ColumnPosition(int columnPosition) {
        validatePositionRange(columnPosition);
        this.columnPosition = columnPosition;
    }

    public void validatePositionRange(int columnPosition) {
        if (columnPosition < MIN) {
            throw new IllegalArgumentException("[ERROR] 열 위치는 " + MIN + "이상이어야 합니다.");
        }
    }

    public ColumnPosition nextPosition(int moveWeight) {
        return new ColumnPosition(columnPosition + moveWeight);
    }

    public int getColumnPosition() {
        return columnPosition;
    }
}
