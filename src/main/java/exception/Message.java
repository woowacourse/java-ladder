package exception;

public enum Message {
    BLANK_INPUT_ERROR("빈 문자열 입력입니다. 다시 입력해주세요."),
    INVALID_HEIGHT_ERROR("잘못된 사다리 높이 입력입니다. 다시 입력해주세요."),
    INVALID_PLAYER_ERROR("잘못된 참여 인원 이름 입력입니다. 다시 입력해주세요."),
    INVALID_SEPARATOR_ERROR("잘못된 구분자 입력입니다. 다시 입력해주세요."),
    INVALID_PRIZES_ERROR("잘못된 실행 결과 입력입니다. 다시 입력해주세요.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
