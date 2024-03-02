package model;

import java.util.Objects;

public class Index {
    private static final int MINIMUM_NUMBER = 0;

    private final int value;

    public Index(final int rawIndex) {
        validateNegativeIndex(rawIndex);
        this.value = rawIndex;
    }

    private void validateNegativeIndex(final int rawCount) {
        if (rawCount < MINIMUM_NUMBER) {
            throw new IllegalArgumentException("인덱스는 음수일 수 없습니다.");
        }
    }

    public boolean isNotLastIndex(int last) {
        return value < last;
    }

    public boolean isNotStartIndex() {
        return value != 0;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Index index = (Index) o;
        return value == index.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public int getIndex() {
        return value;
    }

    public Index getNext() {
        return new Index(value + 1);
    }

    public Index getPast() {
        return new Index(value - 1);
    }
}
