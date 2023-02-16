package laddergame.domain.message;

public enum ErrorMessage {
    INVALID_HEIGHT_TYPE("[ERROR] 사다리 높이는 숫자를 입력해야 합니다."),
    INVALID_HEIGHT_RANGE("[ERROR] 사다리 높이는 1~10000 사이의 값만 가질 수 있습니다."),
    INVALID_NAME_BLANK("[ERROR] 이름에 공백이 포함될 수 없습니다."),
    INVALID_NANE_LENGTH("[ERROR] 이름은 다섯 글자를 초과할 수 없습니다."),
    INVALID_PARTICIPANT_COUNT("[ERROR] 참여자는 최소 한 명 이상 입력해야 합니다."),
    INVALID_DUPLICATE_NAME("[ERROR] 중복된 이름을 입력할 수 없습니다."),
    INVALID_MATERIAL("[ERROR] 잘못된 사다리 가로대 인자입니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

