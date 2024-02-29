package domain.ladder;

import domain.ladder.attribute.Direction;

import java.util.Objects;

public record Point(int row, int column) {

    public Point move(Direction direction) {
        return switch (direction) {
            case LEFT -> new Point(row - 1, column + 1);
            case RIGHT -> new Point(row + 1, column + 1);
            case DOWN -> new Point(row, column + 1);
        };
    }

    public static class Builder {
        private int row;
        private int column;


        public Builder row(final int row) {
            this.row = row;
            return this;
        }

        public Builder column(final int column) {
            this.column = column;
            return this;
        }

        public Point build() {
            return new Point(row, column);
        }
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (!(object instanceof final Point point)) return false;
        return row == point.row && column == point.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
