package laddergame.domain;

import java.rmi.UnexpectedException;

public class LadderValidator {
    private static final int LEAST_LADDER_HEIGHT = 1;

    static void checkEmpty(final String height) {
        if (height.isEmpty()) {
            throw new IllegalArgumentException("사다리의 높이가 입력되지 않았습니다.");
        }
    }

    static void checkNumeric(final String height) {
        if (!height.matches("(\\d+)?")) {
            throw new NumberFormatException("사다리의 높이는 자연수여야 합니다.\n다시 입력해주세요.");
        }
    }

    static void checkLadderHeight(final String height) {
        if (Integer.parseInt(height) < LEAST_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 최소 1이상이어야 합니다.\n다시 입력해주세요.");
        }
    }

}
