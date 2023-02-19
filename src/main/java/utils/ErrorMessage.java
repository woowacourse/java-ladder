package utils;

import static domain.Name.MAX_NAME_LENGTH;
import static domain.Name.MIN_NAME_LENGTH;

public enum ErrorMessage {

    INVALID_USER_NAME_LENGTH(String.format("이름의 길이는 %d 이상 %d 이하여야 합니다.", MIN_NAME_LENGTH, MAX_NAME_LENGTH)),
    INVALID_USER_NAME_FORMAT("이름에는 공백이 포함될 수 없습니다."),
    NOT_FOUND_USER("유저가 존재하지 않습니다."),
    INVALID_LADDER_HEIGHT_RANGE("사다리의 높이는 %d 이상입니다."),
    INVALID_LADDER_HEIGHT_INPUT("사다리의 높이는 숫자만 입력 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
