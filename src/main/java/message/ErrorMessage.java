package message;

public enum ErrorMessage {

    INVALID_LADDER_HEIGHT_EXCEPTION("사다리 높이는 1이상 이어야 합니다."),
    INVALID_LADDER_LANGUAGE_EXCEPTION("사다리 높이는 숫자여야 합니다."),
    INVALID_LADDER_WIDTH_EXCEPTION("사다리 너비는 1이상 이어야 합니다."),
    OVERLAPPED_LINE_EXCEPTION("사다리 라인은 연속될 수 없습니다."),

    NO_RESULT_EXCEPTION("실행 결과를 입력해야 합니다."),
    INVALID_RESULT_COUNT_EXCEPTION("실행 결과의 숫자는 플레이어의 수와 같아야합니다."),

    NO_PLAYER_NAME_EXCEPTION("플레이어 이름을 입력해야 합니다."),
    INVALID_PLAYER_NAME_LANGUAGE_EXCEPTION("플레이어 이름은 영어여야 합니다."),
    INVALID_PLAYER_NAME_SIZE_EXCEPTION("플레이어 이름은 5자 이하여야 합니다."),
    INVALID_PLAYER_COUNT_EXCEPTION("플레이어의 숫자는 2명 이상이어야 합니다."),
    NOT_EXIST_PLAYER_NAME_EXCEPTION("존재하지 않는 플레이어 이름입니다."),
    DUPLICATED_PLAYER_NAME_EXCEPTION("중복된 이름의 플레이어는 입력할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[Error] " + message;
    }

    public String getMessageWithCause(String invalidInput) {
        return "[Error] " + message + " 입력값은 " + invalidInput + " 입니다.";
    }

    public String getMessageWithCause(int invalidInput) {
        return "[Error] " + message + " 입력값은 " + invalidInput + " 입니다.";
    }
}
