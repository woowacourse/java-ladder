package domain.validator;

public class PlayerNameValidator {

    private static final int PLAYER_NAME_MAX_LENGTH = 5;

    public static void validate(final String name) {
        validateNotBlank(name);
        validateNameLength(name);
    }

    private static void validateNotBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("참여자 이름은 공백일 수 없습니다.");
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() > PLAYER_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("참여자 이름은 최대 5글자까지 가능합니다.");
        }
    }

}
