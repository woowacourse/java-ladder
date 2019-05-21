package laddergame.domain.ladder;

import java.util.Objects;

public class LadderHeight {
    private final int ladderHeight;

    public LadderHeight(final String height) {
        this.ladderHeight = parse(height);
        checkValidBound();
    }

    private void checkValidBound() {
        if (this.ladderHeight <= 0) {
            throw new IllegalArgumentException("1 이상의 정수를 입력해주세요");
        }
    }

    private int parse(final String height) {
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
