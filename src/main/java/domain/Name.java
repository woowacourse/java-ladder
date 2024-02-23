package domain;

import java.util.regex.Pattern;

public record Name(String name) {
    private static final int NAME_LENGTH_MIN = 1;
    private static final int NAME_LENGTH_MAX = 5;
    private static final String NAME_REGEX_POLICY = "^[A-Za-z0-9]+";

    public Name(String name) {
        this.name = name;
        validateNameLength();
        validateAlphanumericName();
    }

    private void validateNameLength() {
        String errorMessage = String.format("이름의 길이는 %d ~ %d 자 이어야 합니다.", NAME_LENGTH_MIN, NAME_LENGTH_MAX);
        if (NAME_LENGTH_MIN > name.length() || name.length() > NAME_LENGTH_MAX) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void validateAlphanumericName() {
        if (!Pattern.matches(NAME_REGEX_POLICY, name)) {
            throw new IllegalArgumentException("이름이 영어와 숫자가 아니라면 예외가 발생한다");
        }
    }
}
