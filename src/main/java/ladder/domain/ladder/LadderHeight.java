package ladder.domain.ladder;

import java.util.Objects;
import ladder.exception.ErrorMessage;
import ladder.exception.InvalidInputException;

public class LadderHeight {
    public static final int MINIMUM_HEIGHT = 1;
    private final int height;

    public LadderHeight(final int height) {
        validateHeightRange(height);
        this.height = height;
    }

    private void validateHeightRange(final int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new InvalidInputException(ErrorMessage.INVALID_LADDER_HEIGHT_RANGE);
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
        LadderHeight that = (LadderHeight) o;
        return height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }

    public int getHeight() {
        return height;
    }
}
