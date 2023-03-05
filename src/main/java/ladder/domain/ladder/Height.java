package ladder.domain.ladder;

import java.util.Objects;

public class Height {

    private static final int MINIMUM_HEIGHT = 1;
    private static final int MAXIMUM_HEIGHT = 100;
    private static final String ERROR_OF_HEIGHT = String.format(
            "사다리의 높이는 %d이상 %d이하여야 합니다.", MINIMUM_HEIGHT, MAXIMUM_HEIGHT);
    private final int height;

    public Height(final int height) {
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(final int inputHeight) {
        if (inputHeight < MINIMUM_HEIGHT || inputHeight > MAXIMUM_HEIGHT) {
            throw new IllegalArgumentException(ERROR_OF_HEIGHT);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
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
