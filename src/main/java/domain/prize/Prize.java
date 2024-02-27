package domain.prize;

import java.util.regex.Pattern;

public class Prize {
    private static final int MAX_PRIZE_LENGTH = 10;
    private static final int MIN_PRIZE_LENGTH = 1;
    private static final Pattern PRIZE_PATTERN = Pattern.compile("^[a-zA-Z가-힣0-9]*$");
    private static final String PRIZE_LENGTH_EXCEPTION_MESSAGE = "[ERROR] 잘못된 상품명: %s - 상품명의 길이는 %d ~ %d 글자여야 합니다.";
    private static final String PRIZE_PATTERN_EXCEPTION_MESSAGE = "[ERROR] 잘못된 상품명: %s - 상품명은 한글, 영문자, 숫자만 가능합니다.";

    private final String prize;

    public Prize(String prize) {
        validateLength(prize);
        validatePattern(prize);
        this.prize = prize;
    }

    private void validateLength(String prize) {
        if (prize.length() < MIN_PRIZE_LENGTH || MAX_PRIZE_LENGTH < prize.length()) {
            throw new IllegalArgumentException(
                    String.format(PRIZE_LENGTH_EXCEPTION_MESSAGE, prize, MIN_PRIZE_LENGTH, MAX_PRIZE_LENGTH)
            );
        }
    }

    private void validatePattern(String prize) {
        if (!PRIZE_PATTERN.matcher(prize).matches()) {
            throw new IllegalArgumentException(
                    String.format(PRIZE_PATTERN_EXCEPTION_MESSAGE, prize)
            );
        }
    }
}
