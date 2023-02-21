package laddergame.domain;

import java.util.Objects;

public class Height {

    private static final int MIN_HEIGHT = 1;
    private final int height;

    public Height(final int height) {
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(final int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(String.format("최소 높이가 %d이상이어야 합니다.", MIN_HEIGHT));
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Height height1 = (Height) o;
        return height == height1.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }

    public int getHeight() {
        return height;
    }
}
