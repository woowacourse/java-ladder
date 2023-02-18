package ladder.domain;

import java.util.Objects;

import ladder.error.ErrorMessage;

public class LadderHeight {
    private static final int MIN_LADDER_HEIGHT = 1;
    private static final int MAX_LADDER_HEIGHT = 10000;

    private final int ladderHeight;

    public LadderHeight(int ladderHeight) {
        validate(ladderHeight);
        this.ladderHeight = ladderHeight;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    private void validate(int ladderHeight) {
        if (ladderHeight < MIN_LADDER_HEIGHT || ladderHeight > MAX_LADDER_HEIGHT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_HEIGHT_RANGE.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LadderHeight ladderHeight = (LadderHeight)o;
        return this.ladderHeight == ladderHeight.ladderHeight;
    }

    @Override
    public int hashCode() {
        return Objects.hash();
    }
}
