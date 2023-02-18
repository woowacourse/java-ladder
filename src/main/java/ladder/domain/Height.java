package ladder.domain;

import java.util.Objects;

import ladder.error.ErrorMessage;

public class Height {
    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 10000;

    private final int height;

    public Height(int height) {
        validate(height);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    private void validate(int height) {
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_HEIGHT_RANGE.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Height height = (Height)o;
        return this.height == height.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash();
    }
}
