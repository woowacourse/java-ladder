package model.ladder;

import java.util.Objects;

public class Height {
    private static final int MIN_LADDER_HEIGHT = 1;

    private final int value;

    public Height(int value) {
        validateHeight(value);
        this.value = value;
    }

    private void validateHeight(int value) {
        if (value < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 " + MIN_LADDER_HEIGHT + " 이상이어야한다");
        }
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Height height = (Height) o;
        return value == height.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
