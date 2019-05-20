package com.woowacourse.ladder.domain;

import java.util.Objects;

public class LadderHeight {
    private static final int MIN = 1;

    private final int height;

    public LadderHeight(int height) {
        if (height < MIN) {
            throw new IllegalArgumentException();
        }
        this.height = height;
    }

    public int get() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderHeight that = (LadderHeight) o;
        return height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}
