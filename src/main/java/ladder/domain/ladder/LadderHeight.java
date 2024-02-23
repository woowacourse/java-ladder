package ladder.domain.ladder;

import java.util.Objects;

public class LadderHeight {
    private static final int MINIMUM_HEIGHT = 1;

    private final int height;

    public LadderHeight(int height) {
        validateHeightRange(height);
        this.height = height;
    }

    private void validateHeightRange(int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException(String.format("사다리의 높이는 %d이상이어야 합니다.", MINIMUM_HEIGHT));
        }
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderHeight that = (LadderHeight) o;
        return height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}
