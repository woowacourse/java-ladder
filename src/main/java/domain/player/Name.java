package domain.player;

import java.util.regex.Pattern;

public record Name(String rawName) {

    private static final Pattern NAME_REGEX = Pattern.compile("^[a-z]*$");
    private static final int MAX_NAME_LENGTH = 5;

    public Name {
        validateNameLength(rawName);
        validateNamePattern(rawName);
    }

    private void validateNameLength(String name) {
        if (name == null || isNameLengthOutOfRange(name)) {
            throw new IllegalArgumentException("이름은 1자 이상 5자 이하여야 합니다.");
        }
    }

    private boolean isNameLengthOutOfRange(String name) {
        return name.isEmpty() || name.length() > MAX_NAME_LENGTH;
    }

    private void validateNamePattern(String name) {
        boolean isPatternMatches = NAME_REGEX.matcher(name).matches();
        if (!isPatternMatches) {
            throw new IllegalArgumentException("이름은 알파벳 소문자로만 작성해야 합니다.");
        }
    }
}
