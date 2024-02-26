package laddergame.domain.ladder;

import java.util.Objects;

public class LadderHeight {

    private final int height;

    public LadderHeight(final int input) {
        validatePositive(input);
        this.height = input;
    }

    private void validatePositive(final int input) {
        if (input <= 0) {
            throw new IllegalArgumentException("[ERROR] 입력값은 양수만 가능합니다.");
        }
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final LadderHeight that)) {
            return false;
        }
        return getHeight() == that.getHeight();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeight());
    }
}
