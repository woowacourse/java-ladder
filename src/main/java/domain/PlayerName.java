package domain;

import static message.ErrorMessage.INVALID_PLAYER_NAME_LANGUAGE_EXCEPTION;
import static message.ErrorMessage.INVALID_PLAYER_NAME_SIZE_EXCEPTION;
import static message.ErrorMessage.NO_PLAYER_NAME_EXCEPTION;

import java.util.regex.Pattern;

public class PlayerName {

    private static final Pattern NAME_LANGUAGE_FORMAT_PATTERN = Pattern.compile("^[A-Za-z]*$");
    private static final int MAXIMUM_NAME_SIZE = 5;

    private final String name;

    public PlayerName(String name) {
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
        if (!NAME_LANGUAGE_FORMAT_PATTERN.matcher(name).matches()) {
            throw new IllegalArgumentException(INVALID_PLAYER_NAME_LANGUAGE_EXCEPTION.getMessage());
        }
    }

    private void validateNameSize(String name) {
        if (name.length() > MAXIMUM_NAME_SIZE) {
            throw new IllegalArgumentException(INVALID_PLAYER_NAME_SIZE_EXCEPTION.getMessage());
        }
    }

    public boolean isEqualName(String otherName) {
        return this.name.equals(otherName);
    }

    public String getName() {
        return name;
    }
}
