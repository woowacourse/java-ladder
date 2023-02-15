package laddergame.domain.ladder;

public class LadderFactory {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 10_000;

    public void createLadder(String height) {
        int ladderHeight = validateHeightType(height);
        validateHeightRange(ladderHeight);
    }

    private int validateHeightType(final String height) {
        try {
            return Integer.parseInt(height);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 사다리 높이는 숫자를 입력해야 합니다.");
        }
    }

    private void validateHeightRange(final int height) {
        if (height < MIN_RANGE || height > MAX_RANGE) {
            throw new IllegalArgumentException("[ERROR] 사다리 높이는 1~10000 사이의 값만 가질 수 있습니다.");
        }
    }
}
