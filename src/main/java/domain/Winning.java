package domain;

import java.util.Objects;

public class Winning {
    private static final String WINNING_STYLE = "^[a-zA-Z가-힣0-9_-]+$";

    private final String winning;

    public Winning(String inputWinning) {
        validateLength(inputWinning);
        validateStyle(inputWinning);
        this.winning = inputWinning;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winning winning1 = (Winning) o;
        return Objects.equals(winning, winning1.winning);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winning);
    }

    private void validateLength(String inputWinning) {
        if (inputWinning.isEmpty() || inputWinning.length() > 5) {
            throw new IllegalArgumentException("실행결과의 길이는 1글자 이상 5글자 이하여야 합니다.");
        }
    }

    private void validateStyle(String inputName) {
        if (!inputName.matches(WINNING_STYLE)) {
            throw new IllegalArgumentException("실행결과는 영어, 한글, 숫자, '_', '-'로만 이루어져야 합니다.");
        }
    }

    public String getWinning() {
        return winning;
    }
}
