package domain;

import domain.ladder.common.Direction;

public class Point {
    int row;
    int column;

    public Point(final int row, final int column) {
        this.row = row;
        this.column = column;
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

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
