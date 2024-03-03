package domain;

import java.util.Objects;

public class ColumnPosition {

    private static final int MIN = 0;
    private final int columnPosition;

    public ColumnPosition(int columnPosition) {
        validatePositionRange(columnPosition);
        this.columnPosition = columnPosition;
    }

    public ColumnPosition nextPosition(int moveWeight) {
        return new ColumnPosition(columnPosition + moveWeight);
    }

    public int getColumnPosition() {
        return columnPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ColumnPosition that = (ColumnPosition) o;
        return columnPosition == that.columnPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(columnPosition);
    }

    private void validatePositionRange(int columnPosition) {
        if (columnPosition < MIN) {
            throw new IllegalArgumentException("[ERROR] 열 위치는 " + MIN + "이상이어야 합니다.");
        }
    }
}
