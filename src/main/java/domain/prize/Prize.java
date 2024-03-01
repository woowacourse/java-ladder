package domain.prize;

import java.util.regex.Pattern;

public class Prize {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 10;
    private static final Pattern PRIZE_NAME_PATTERN = Pattern.compile("^[a-zA-Z가-힣0-9]*$");
    private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "[ERROR] 잘못된 상품명: %s - 상품명의 길이는 %d ~ %d 글자여야 합니다.";
    private static final String NAME_PATTERN_EXCEPTION_MESSAGE = "[ERROR] 잘못된 상품명: %s - 상품명은 한글, 영문자, 숫자만 가능합니다.";

    private final String name;

    public Prize(String name) {
        validateLength(name);
        validateNamePattern(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || MAX_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException(
                    String.format(NAME_LENGTH_EXCEPTION_MESSAGE, name, MIN_NAME_LENGTH, MAX_NAME_LENGTH)
            );
        }
    }

    private void validateNamePattern(String name) {
        if (!PRIZE_NAME_PATTERN.matcher(name).matches()) {
            throw new IllegalArgumentException(
                    String.format(NAME_PATTERN_EXCEPTION_MESSAGE, name)
            );
        }
    }

    public int getNameLength() {
        return this.name.length();
    }

    public String getName() {
        return this.name;
    }
}
