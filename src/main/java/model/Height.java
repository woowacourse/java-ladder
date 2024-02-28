package model;

import java.util.Objects;

public record Height(int value) {

    private static final String NOT_POSITIVE_HEIGHT = "최대 사다리의 높이는 양수가 되어야 합니다.";

    public Height {
        if (value <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_HEIGHT);
        }
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
