package domain;

import java.util.regex.Pattern;

public record Name(String value) {

    private static final Pattern NAME_REGEX = Pattern.compile("^[a-z]*$");
    private static final int MAX_NAME_LENGTH = 5;

    public Name {
        validateNameLength(value);
        validateNamePattern(value);
    }

    private void validateNameLength(String value) {
        if (value == null || isNameLengthOutOfRange(value)) {
            throw new IllegalArgumentException("이름은 1자 이상 5자 이하여야 합니다.");
        }
    }

    private boolean isNameLengthOutOfRange(String value) {
        return value.isEmpty() || value.length() > MAX_NAME_LENGTH;
    }

    private void validateNamePattern(String value) {
        boolean isPatternMatches = NAME_REGEX.matcher(value).matches();
        if (!isPatternMatches) {
            throw new IllegalArgumentException("이름은 알파벳 소문자로만 작성해야 합니다.");
        }
    }
}
