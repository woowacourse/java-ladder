package view;

public class LadderHeightInputView {
    public static int getLadderHeight(String rawString) {
        try {
            return Integer.parseInt(rawString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}
