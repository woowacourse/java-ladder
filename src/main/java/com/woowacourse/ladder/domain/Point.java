package com.woowacourse.ladder.domain;

import java.util.Objects;

public class Point {
    private final int position;
    private final int max;

    public Point(int position, int max) {
        if (position < 0) {
            throw new IllegalArgumentException();
        }

        if (position > max || max > 1000) {
            throw new IllegalArgumentException();
        }
        this.position = position;
        this.max = max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return position == point.position &&
                max == point.max;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, max);
    }
}
