package ladder.domain;

import java.util.Objects;

public class Height {
    public static final int MIN_HEIGHT = 1;

    private final int height;

    Height(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("높이는 " + MIN_HEIGHT + " 보다 커야합니다");
        }
        this.height = height;
    }

    public static Height create(int height) {
        return new Height(height);
    }

    public int toInt() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Height height1 = (Height) o;
        return height == height1.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}
