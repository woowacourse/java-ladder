package domain.db;

import java.util.regex.Pattern;

public record Name(String name) {
    private static final int NAME_LENGTH_MIN = 1;
    private static final int NAME_LENGTH_MAX = 5;
    private static final Pattern NAME_REGEX_PATTERN = Pattern.compile("^[A-Za-z0-9]+");

    public Name(final String name) {
        this.name = removeBlank(name);
        validateNameLength();
        validateAlphanumericName();
    }

    private String removeBlank(final String name) {
        return name.replace(" ", "");
    }

    private void validateNameLength() {
        final String errorMessage = String.format("이름의 길이는 %d ~ %d 자 이어야 합니다.", NAME_LENGTH_MIN, NAME_LENGTH_MAX);
        if (this.name == null) {
            throw new IllegalArgumentException(errorMessage);
        }
        if (NAME_LENGTH_MIN > this.name.length() || this.name.length() > NAME_LENGTH_MAX) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void validateAlphanumericName() {
        if (!NAME_REGEX_PATTERN.matcher(this.name).matches()) {
            throw new IllegalArgumentException("이름은 영어와 숫자만 허용합니다.");
        }
    }
}
