package laddergame.domain;

public class LadderValidator {
    private static final int LEAST_LADDER_HEIGHT = 1;

    static void checkNumeric(final String height) {
        if (!height.matches("(\\d+)?")) {
            throw new IllegalArgumentException("사다리의 높이는 자연수여야 합니다.\n다시 입력해주세요.");
        }
    }

    static void checkLadderHeightLadder(final String height) {
        if (Integer.parseInt(height) < LEAST_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 최소 1이상이어야 합니다.\n다시 입력해주세요.");
        }
    }

}
