package view;

public class LadderHeightInputView {
    public static int getLadderHeight(String rawString) {
        int ladderHeight = parseInteger(rawString);
        if (ladderHeight < 2 || ladderHeight > 20) {
            throw new IllegalArgumentException("사다리 높이는 2 이상 20 이하여야 합니다.");
        }
        return ladderHeight;
    }

    private static int parseInteger(String rawString) {
        try {
            return Integer.parseInt(rawString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}
