package laddergame.domain.ladder;

import java.util.Objects;

public class LadderHeight {
    private static final int MIN_NUM_OF_LADDER_HEIGHT = 0;
    private final int ladderHeight;

    private LadderHeight(final int height) {
        this.ladderHeight = height;
        checkValidBound();
    }

    public static LadderHeight of(final int height) {
        return new LadderHeight(height);
    }

    private void checkValidBound() {
        if (this.ladderHeight <= MIN_NUM_OF_LADDER_HEIGHT) {
            throw new IllegalArgumentException("1 이상의 정수를 입력해주세요");
        }
    }

    int getLadderHeight() {
        return this.ladderHeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderHeight)) return false;
        LadderHeight that = (LadderHeight) o;
        return Objects.equals(ladderHeight, that.ladderHeight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderHeight);
    }
}
