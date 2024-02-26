package domain;

import java.util.regex.Pattern;

import static message.ErrorMessage.*;

public class Name {

    private static final Pattern NAME_LANGUAGE_FORMAT = Pattern.compile("^[A-Za-z]*$");
    private static final int MAXIMUM_NAME_SIZE = 5;
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
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(NO_PLAYER_NAME_EXCEPTION.getMessageWithCause(name));
        }
    }

    private void validateNameLanguage(String name) {
        if (!NAME_LANGUAGE_FORMAT.matcher(name).matches()) {
            throw new IllegalArgumentException(INVALID_PLAYER_NAME_LANGUAGE_EXCEPTION.getMessageWithCause(name));
        }
    }

    private void validateNameSize(String name) {
        if (name.length() > MAXIMUM_NAME_SIZE) {
            throw new IllegalArgumentException(INVALID_PLAYER_NAME_SIZE_EXCEPTION.getMessageWithCause(name));
        }
    }

    public String getName() {
        return name;
    }
}
