package domain;

import java.util.regex.Pattern;

public class Prize {

    static final String LOSE = "꽝";
    static final String ERROR_IS_NOT_LOSE_OR_NATURAL_NUMBER = "실행 결과는 " + LOSE + " 또는 자연수만 입력 가능합니다.";
    private static final Pattern NATURAL_NUMBER_FORMAT_REGEX = Pattern.compile("^[1-9][0-9]*$");

    private String prize;

    public Prize(String prize) {
        validateIsNotLoseOrNaturalNumber(prize);
        this.prize = prize;
    }

    private void validateIsNotLoseOrNaturalNumber(String prize) {
        if (!prize.equals(LOSE) && !NATURAL_NUMBER_FORMAT_REGEX.matcher(prize).matches()) {
            throw new IllegalArgumentException(ERROR_IS_NOT_LOSE_OR_NATURAL_NUMBER);
        }
    }

    public String getPrize() {
        return prize;
    }
}
