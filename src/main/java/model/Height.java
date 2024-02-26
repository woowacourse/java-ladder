package model;

public class Height {
    private final int ladderHeight;

    public Height(String input) {
        ladderHeight = parseInt(input);
        validateLadderHeightRange(ladderHeight);
    }

    public boolean isDesignatedHeight(int currentHeight) {
        return currentHeight == ladderHeight;
    }

    private void validateLadderHeightRange(int ladderHeight) {
        if (ladderHeight < 1) {
            throw new IllegalArgumentException("[ERROR] 사다리 높이는 1 이상의 정수이어야 한다.");
        }
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값은 숫자형식이어야 한다.");
        }
    }
}
