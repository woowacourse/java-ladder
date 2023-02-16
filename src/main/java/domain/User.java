package domain;

public class User {
    private static final int USER_NAME_MIN_LENGTH = 1;
    private static final int USER_NAME_MAX_LENGTH = 5;
    private final String name;

    public User(String name) {
        validateNameLength(name);
        validateBlankName(name);

        this.name = name;
    }

    private void validateNameLength(String name) {
        if (USER_NAME_MIN_LENGTH > name.length() || USER_NAME_MAX_LENGTH < name.length()) {
            throw new IllegalArgumentException("이름은 1~5 글자 입니다.");
        }
    }

    private void validateBlankName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백으로만 이루어지면 안됩니다.");
        }
    }
}
