package laddergame.domain;

class Column {

    private final int column;

    public Column(int column) {
        validateNegative(column);

        this.column = column;
    }

    private void validateNegative(int column) {
        if (column < 0) {
            throw new IllegalArgumentException("컬럼은 음수가 될 수 없습니다.");
        }
    }

    public Column change(Direction direction) {
        if (direction.isRight()) {
            return new Column(column + 1);
        }

        if (direction.isLeft()) {
            return new Column(column - 1);
        }

        return this;
    }

    public boolean isGreaterThan(int target) {
        return column > target;
    }

    public boolean isZero() {
        return column == 0;
    }

    public int getValue() {
        return column;
    }
}
