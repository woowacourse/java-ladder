package domain;

import common.exception.message.ExceptionMessage;

public class PlayerName {
    private final String name;

    // TODO : PlayerName 객체만 생성할 때에는 blank 검증 말곤 하진 않고 있다. (이름 정책에 대한 검증이 없음)
    public PlayerName(final String name) {
        validateIsBlank(name);
        this.name = name;
    }

    private void validateIsBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.PLAYER_NAME_BLANK);
        }
    }

    public String getName() {
        return name;
    }
}
