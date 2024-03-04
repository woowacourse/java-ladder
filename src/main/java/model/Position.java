package model;

import model.path.Path;

public record Position(int depth, int column) {

    public Position getLeftPosition() {
        return new Position(depth, column - 1);
    }

    public Position getRightPosition() {
        return new Position(depth, column + 1);
    }

    public Position getBelowPosition() {
        return new Position(depth + 1, column);
    }

    public void checkWithinLine(final Line line) {
        final int maxLineColumn = line.size() + 1;
        if (column < 0 || column > maxLineColumn) {
            throw new IllegalStateException("올바르지 않은 위치입니다.");
        }
    }

    public boolean isFarLeft() {
        return column == 0;
    }

    public boolean isFarRight(final Line line) {
        final int lastIndexOfLine = line.size();
        return column == lastIndexOfLine;
    }

    public int getLeftPathIndex() {
        if (column <= 0) {
            throw new IllegalArgumentException(column + " 왼쪽의 경로는 없습니다.");
        }
        return column - 1;
    }

    public int getRightPathIndex(final Line line) {
        final int maxIndexOfColumn = line.size() + 1;
        if (column >= maxIndexOfColumn) {
            throw new IllegalArgumentException(column + " 오른쪽의 경로는 없습니다.");
        }
        return column;
    }
}
