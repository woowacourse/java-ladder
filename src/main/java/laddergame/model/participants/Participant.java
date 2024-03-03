package laddergame.model.participants;

import laddergame.exception.BaseException;

public record Participant(String name) {
    private static final int MAXIMUM_NAME_LENGTH = 5;

    public Participant {
        validateNameLength(name);
    }

    private void validateNameLength(String name) {
        if (name == null || name.isBlank()) {
            String message = "참여자 이름은 null이거나 공백일 수 없습니다. 입력값:" + name;
            throw new BaseException(message);
        }
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            String message = "참여자 이름의 길이는 " + MAXIMUM_NAME_LENGTH + "자를 초과할 수 없습니다. 입력값:" + name;
            throw new BaseException(message);
        }
    }
}
