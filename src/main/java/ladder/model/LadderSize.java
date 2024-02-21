package ladder.model;

import java.util.Objects;

public class LadderSize {
    private final int height;
    private final int width;

    public LadderSize(int height, int width) {
        validate(height, width);
        this.height = height;
        this.width = width;
    }

    private void validate(int height, int width) {
        if (!isNaturalNumber(height)) {
            throw new IllegalArgumentException("사다리 높이는 자연수여야 합니다.");
        }
        if (!isNaturalNumber(width)) {
            throw new IllegalArgumentException("사다리 너비는 자연수여야 합니다.");
        }
    }

    private boolean isNaturalNumber(int value) {
        return value > 0;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LadderSize that = (LadderSize) o;
        return height == that.height && width == that.width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width);
    }
}
