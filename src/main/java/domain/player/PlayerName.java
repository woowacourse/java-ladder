package domain.player;

import common.exception.model.ValidationException;

import java.util.regex.Pattern;

public class PlayerName {
    public static final String BLANK_ERROR_MESSAGE = "참가자 이름으로 공백을 사용할 수 없습니다";
    public static final String FORMAT_ERROR_MESSAGE = "참가자 이름은 문자(영어 or 한글)여야 합니다";
    public static final String LENGTH_ERROR_MESSAGE = String.format("참가자 이름의 길이는 %d 이상, %d 이하여야 합니다",
            PlayerName.LENGTH_MIN, PlayerName.LENGTH_MAX);
    public static final int LENGTH_MIN = 1;
    public static final int LENGTH_MAX = 5;
    private static final Pattern PLAYER_NAME_PATTERN = Pattern.compile("[가-힣a-zA-Z]+");

    private final String value;

    public PlayerName(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String name) {
        validateLength(name);
        validateIsBlank(name);
        validateFormat(name);
    }

    private void validateFormat(String name) {
        if (!PLAYER_NAME_PATTERN.matcher(name).matches()) {
            throw new ValidationException(FORMAT_ERROR_MESSAGE);
        }
    }

    private void validateLength(String name) {
        if (name.length() < LENGTH_MIN || name.length() > LENGTH_MAX) {
            throw new ValidationException(LENGTH_ERROR_MESSAGE);
        }
    }

    private void validateIsBlank(String name) {
        if (name.isBlank()) {
            throw new ValidationException(BLANK_ERROR_MESSAGE);
        }
    }

    public String getValue() {
        return value;
    }
}
