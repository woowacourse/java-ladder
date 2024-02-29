package domain;

import java.util.Objects;

public class Height {

    private static final int MAX_HEIGHT = 50;

    private final int height;

    public Height(int height) {
        validateRange(height);
        this.height = height;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Height height1 = (Height) obj;
        return height == height1.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }

    private void validateRange(int height) {
        if (height < 1 || height > MAX_HEIGHT) {
            throw new IllegalArgumentException(String.format("사다리의 높이는 1 이상 %d 이하여야 합니다.", MAX_HEIGHT));
        }
    }

    public int getHeight() {
        return height;
    }
}

