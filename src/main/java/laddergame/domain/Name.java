package laddergame.domain;

import static laddergame.utils.ErrorMessage.INVALID_USER_NAME_ALL;
import static laddergame.utils.ErrorMessage.INVALID_USER_NAME_FORMAT;
import static laddergame.utils.ErrorMessage.INVALID_USER_NAME_LENGTH;

public class Name {
    private static final int MIN_NAME_LENGTH = 1;
    private static final String ALL = "all";
    private static final String BLANK = " ";
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        validateNameLength(name);
        validateNameFormat(name);
    }

    private void validateNameLength(String name) {
        if (isLongerThanMaxLength(name) || isShorterThanMinLength(name)) {
            throw new IllegalArgumentException(
                    String.format(INVALID_USER_NAME_LENGTH.getMessage(), MIN_NAME_LENGTH, MAX_NAME_LENGTH));
        }
    }

    private boolean isShorterThanMinLength(String name) {
        return name.length() < MIN_NAME_LENGTH;
    }

    private boolean isLongerThanMaxLength(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    private void validateNameFormat(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException(INVALID_USER_NAME_FORMAT.getMessage());
        }
        if (name.equals(ALL)) {
            throw new IllegalArgumentException(INVALID_USER_NAME_ALL.getMessage());
        }
    }

    public String getName() {
        return name;
    }
}
