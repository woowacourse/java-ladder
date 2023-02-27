package ladder.domain;

import java.util.List;

public class Name {
    private static final int NAME_LENGTH_LOWER_BOUND_INCLUSIVE = 1;
    private static final int NAME_LENGTH_UPPER_BOUND_INCLUSIVE = 5;
    private static final List<String> NOT_ALLOWED = List.of("all", "end");
    private static final String NAME_LENGTH_ERROR_MESSAGE = "플레이어 이름 길이는 1이상 5이하여야합니다.";
    private static final String NAME_BLANK_ERROR_MESSAGE = "플레이어 이름은 공백으로만 이루어질 수 없습니다.";
    private static final String NOT_ALLOWED_ERROR_MESSAGE = "플레이어 이름은 %s가 될 수 없습니다.";
    private static final String NAME_DELIMITER = ", ";
    private final String name;

    public Name(String name) {
        validateLength(name);
        validateOnlyBlank(name);
        validateNotAllowedWord(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() < NAME_LENGTH_LOWER_BOUND_INCLUSIVE || name.length() > NAME_LENGTH_UPPER_BOUND_INCLUSIVE) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private void validateOnlyBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(NAME_BLANK_ERROR_MESSAGE);
        }
    }

    private void validateNotAllowedWord(String name) {
        if (isNotAllowedWord(name)) {
            throw new IllegalArgumentException(
                    String.format(NOT_ALLOWED_ERROR_MESSAGE, String.join(NAME_DELIMITER, NOT_ALLOWED))
            );
        }
    }

    private boolean isNotAllowedWord(String word) {
        return NOT_ALLOWED.stream().anyMatch(notAllowedWord ->
                notAllowedWord.equals(word)
        );
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Name)) {
            return false;
        }
        Name other = (Name) obj;
        return name.equals(other.name);
    }
}
