package model;

public record Position(int depth, int column) {
    public Position {
        validateNegativePosition(depth, column);
    }

    private void validateNegativePosition(final int depth, final int column) {
        if (depth < 0 || column < 0) {
            throw new IllegalArgumentException("위치는 음수일 수 없습니다.");
        }
    }

    public Position getLeftPosition() {
        return new Position(depth, column - 1);
    }

    public Position getRightPosition() {
        return new Position(depth, column + 1);
    }
}
