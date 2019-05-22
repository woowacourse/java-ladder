package laddergame.domain.ladder;

import java.util.Objects;

public class LadderHeight {
    private static final int ZERO_BOUND = 0;

    private final int ladderHeight;

    public LadderHeight(String height) {
        this.ladderHeight = toInt(height);
        checkValidBound();
    }

    private void checkValidBound() {
        if (this.ladderHeight <= ZERO_BOUND) {
            throw new IllegalArgumentException("1 이상의 정수를 입력해주세요");
        }
    }

    private int toInt(String height) {
        try {
            return Integer.parseInt(height);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    public int getLadderHeight() {
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
