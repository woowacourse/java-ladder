package domain;

import common.exception.message.ExceptionMessage;
import common.exception.model.ValidationException;

import java.util.regex.Pattern;

public class PlayerName {
    public static final int PLAYER_NAME_MIN_LENGTH = 1;
    public static final int PLAYER_NAME_MAX_LENGTH = 5;
    private static final Pattern PLAYER_NAME_PATTERN = Pattern.compile("[가-힣a-zA-Z]+");

    private String name;

    public PlayerName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateLength(name);
        validateIsBlank(name);
        validateFormat(name);
    }

    private void validateFormat(String name) {
        if (!PLAYER_NAME_PATTERN.matcher(name).matches()) {
            throw new ValidationException(ExceptionMessage.PLAYER_NAMES_FORMAT);
        }
    }

    private void validateLength(String name) {
        if (name.length() < PLAYER_NAME_MIN_LENGTH || name.length() > PLAYER_NAME_MAX_LENGTH) {
            throw new ValidationException(ExceptionMessage.PLAYER_NAME_LENGTH);
        }
    }

    private void validateIsBlank(String name) {
        if (name.isBlank()) {
            throw new ValidationException(ExceptionMessage.PLAYER_NAME_BLANK);
        }
    }

    public String getName() {
        return name;
    }
}
