package domain;

public class Winning {
    private static final String WINNING_STYLE = "^[a-zA-Z가-힣0-9_-]+$";

    private final String winning;

    public Winning (String inputWinning) {
        validateLength(inputWinning);
        validateStyle(inputWinning);
        this.winning = inputWinning;
    }

    private void validateLength(String inputWinning) {
        if (inputWinning.isEmpty() || inputWinning.length() > 5) {
            throw new IllegalArgumentException("실행결과의 길이는 1글자 이상 5글자 이하여야 합니다.");
        }
    }

    private void validateStyle(String inputName) {
        if (!inputName.matches(WINNING_STYLE)){
            throw new IllegalArgumentException("실행결과는 영어, 한글, 숫자, '_', '-'로만 이루어져야 합니다.");
        }
    }
}
