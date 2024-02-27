package domain.prize;

import java.util.regex.Pattern;

public class Prize {
    private static final int MAX_PRIZE_NAME_LENGTH = 10;
    private static final int MIN_PRIZE_NAME_LENGTH = 1;
    private static final Pattern PRIZE_NAME_PATTERN = Pattern.compile("^[a-zA-Z가-힣0-9]*$");
    private static final String PRIZE_LENGTH_EXCEPTION_MESSAGE = "[ERROR] 잘못된 상품명: %s - 상품명의 길이는 %d ~ %d 글자여야 합니다.";
    private static final String PRIZE_PATTERN_EXCEPTION_MESSAGE = "[ERROR] 잘못된 상품명: %s - 상품명은 한글, 영문자, 숫자만 가능합니다.";

    private final String name;

    public Prize(String name) {
        validateLength(name);
        validatePattern(name);
        this.name = name;
    }

    private void validateLength(final String name) {
        if (name.length() < MIN_PRIZE_NAME_LENGTH || MAX_PRIZE_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException(
                    String.format(PRIZE_LENGTH_EXCEPTION_MESSAGE, name, MIN_PRIZE_NAME_LENGTH, MAX_PRIZE_NAME_LENGTH)
            );
        }
    }

    private void validatePattern(final String name) {
        if (!PRIZE_NAME_PATTERN.matcher(name).matches()) {
            throw new IllegalArgumentException(
                    String.format(PRIZE_PATTERN_EXCEPTION_MESSAGE, name)
            );
        }
    }
}
