package ladder.domain;

import java.util.Objects;

public class Height {

    private static final int MINIMUM_HEIGHT = 1;
    private final int height;

    public Height(final int height) {
        validateHeight(height);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    private void validateHeight(int inputHeight) {
        if(inputHeight < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상이어야 합니다.");
        }
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
