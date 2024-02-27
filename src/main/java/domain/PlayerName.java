package domain;

import common.exception.message.ExceptionMessage;

public class PlayerName {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    private final String name;

    // TODO : PlayerName 객체만 생성할 때에는 blank 검증 말곤 하진 않고 있다. (이름 정책에 대한 검증이 없음)
    public PlayerName(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateIsBlank(name);
        validateNameLength(name);
    }

    private void validateIsBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.PLAYER_NAME_BLANK);
        }
    }

    private void validateNameLength(final String name) {
        int nameLength = name.length();
        if (nameLength > MAX_NAME_LENGTH || nameLength < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.PLAYER_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }
}
