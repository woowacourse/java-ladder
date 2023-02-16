package domain;

public class User {
    private static final int USER_NAME_MIN_LENGTH = 1;
    private static final int USER_NAME_MAX_LENGTH = 5;
    private static final String INVALID_NAME_LENGTH_MESSAGE = "이름은 1~5 글자만 가능합니다.";
    private static final String INVALID_NAME_BLANK_MESSAGE = "이름은 공백으로만 이루어지면 안됩니다.";
    private final String name;

    public User(String name) {
        validateNameLength(name);
        validateBlankName(name);

        this.name = name;
    }

    private void validateNameLength(String name) {
        if (USER_NAME_MIN_LENGTH > name.length() || USER_NAME_MAX_LENGTH < name.length()) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_MESSAGE);
        }
    }

    private void validateBlankName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(INVALID_NAME_BLANK_MESSAGE);
        }
    }
}
