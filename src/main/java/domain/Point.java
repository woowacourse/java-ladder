package domain;

import domain.ladder.common.Direction;

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


}
