package domain;

public class Winning {
    private final String winning;

    public Winning (String inputWinning) {
        validateLength(inputWinning);
        this.winning = inputWinning;
    }

    private void validateLength(String inputWinning) {
        if (inputWinning.isEmpty() || inputWinning.length() > 5) {
            throw new IllegalArgumentException("실행결과의 길이는 1글자 이상 5글자 이하여야 합니다.");
        }
    }
}
