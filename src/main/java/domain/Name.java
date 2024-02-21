package domain;

import static message.ErrorMessage.INVALID_PLAYER_NAME_LANGUAGE_EXCEPTION;
import static message.ErrorMessage.INVALID_PLAYER_NAME_SIZE_EXCEPTION;
import static message.ErrorMessage.NO_PLAYER_NAME_EXCEPTION;

public class Name {

    private static final String NAME_LANGUAGE_FORMAT = "^[A-Za-z]*$";
    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateNameBlank(name);
        validateNameLanguage(name);
        validateNameSize(name);
    }

    private void validateNameBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(NO_PLAYER_NAME_EXCEPTION.getMessage());
        }
    }

    private void validateNameLanguage(String name) {
        if (!name.matches(NAME_LANGUAGE_FORMAT)) {
            throw new IllegalArgumentException(INVALID_PLAYER_NAME_LANGUAGE_EXCEPTION.getMessage());
        }
    }

    private void validateNameSize(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(INVALID_PLAYER_NAME_SIZE_EXCEPTION.getMessage());
        }
    }

    public String getName() {
        return name;
    }
}
