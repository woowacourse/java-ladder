package domain.prize;

import java.util.regex.Pattern;

public class Prize {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 10;
    private static final Pattern PRIZE_NAME_PATTERN = Pattern.compile("^[a-zA-Z가-힣\\d]*$");

    private final String name;

    public Prize(String name) {
        validateLength(name);
        validateNamePattern(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || MAX_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] rejected value: %s - 상품명은 %d ~ %d 글자여야 합니다.",
                            name, MIN_NAME_LENGTH, MAX_NAME_LENGTH)
            );
        }
    }

    private void validateNamePattern(String name) {
        if (!PRIZE_NAME_PATTERN.matcher(name).matches()) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] rejected value: %s - 상품명은 한글, 영문자, 숫자만 가능합니다.", name)
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
