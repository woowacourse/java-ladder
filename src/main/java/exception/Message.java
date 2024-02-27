package exception;

public enum Message {

    //TODO: 예외 메시지가 많아지기 시작한다.
    // 다르게 관리해봐야 하나?
    BLANK_INPUT_ERROR("빈 문자열 입력입니다. 다시 입력해주세요."),
    INVALID_HEIGHT_ERROR("잘못된 사다리 높이 입력입니다. 다시 입력해주세요."),
    INVALID_PLAYER_ERROR("잘못된 참여 인원 이름 입력입니다. 다시 입력해주세요."),
    INVALID_PLAYER_NAME_ERROR("존재하지 않는 사람입니다. 다시 입력해주세요."),
    INVALID_PLAYERS_AND_PRIZES_SIZE("유효하지 않은 참여 인원 수와 실행 결과 수입니다."),
    INVALID_RESULT_ERROR("잘못된 실행 결과 입력입니다. 다시 입력해주세요."),
    INVALID_SEPARATOR_ERROR("잘못된 구분자 입력입니다. 다시 입력해주세요.");

    private final String value;

    Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
