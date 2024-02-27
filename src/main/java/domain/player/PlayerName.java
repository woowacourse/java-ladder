package domain.player;

import common.exception.model.ValidationException;

import java.util.regex.Pattern;

public class PlayerName {
    public static final String PLAYER_NAME_BLANK = "참가자 이름으로 공백을 사용할 수 없습니다";
    public static final String PLAYER_NAME_FORMAT = "참가자 이름은 문자(영어 or 한글)여야 합니다";
    public static final String PLAYER_NAME_LENGTH = String.format("참가자 이름의 길이는 %d 이상, %d 이하여야 합니다",
            PlayerName.PLAYER_NAME_MIN_LENGTH, PlayerName.PLAYER_NAME_MAX_LENGTH);
    public static final int PLAYER_NAME_MIN_LENGTH = 1;
    public static final int PLAYER_NAME_MAX_LENGTH = 5;
    private static final Pattern PLAYER_NAME_PATTERN = Pattern.compile("[가-힣a-zA-Z]+");

    private final String name;

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
            throw new ValidationException(PLAYER_NAME_FORMAT);
        }
    }

    private void validateLength(String name) {
        if (name.length() < PLAYER_NAME_MIN_LENGTH || name.length() > PLAYER_NAME_MAX_LENGTH) {
            throw new ValidationException(PLAYER_NAME_LENGTH);
        }
    }

    private void validateIsBlank(String name) {
        if (name.isBlank()) {
            throw new ValidationException(PLAYER_NAME_BLANK);
        }
    }

    public String getName() {
        return name;
    }
}
