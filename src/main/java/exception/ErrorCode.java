package exception;

public enum ErrorCode {
    HEAD("[ERROR] "),
    NAME_OUT_OF_RANGE("참여자 이름은 %d 글자 ~ %d 글자 사이여야 합니다."),
    RESULT_OUT_OF_RANGE("게임 결과는 %d 글자 ~ %d 글자 사이여야 합니다."),
    NUMBER_NOT_INTEGER("사다리 높이는 정수 값만 입력 가능합니다."),
    NEGATIVE_NUMBER("사다리 높이는 2 이상 이어야 합니다."),
    NAME_DUPLICATE("이름은 중복되면 안됩니다."),
    EMPTY_INPUT("빈 값은 입력할 수 없습니다."),
    WRONG_WINNING_ENTRY_SIZE("결과는 게임 참여자 수 만큼 입력해야 합니다."),
    WRONG_RESULT_TARGET("참여자 1명의 이름 또는 \"all\"만 입력 가능합니다."),
    NOT_ENOUGH_PLAYER("사다리 게임 참여자는 2명 이상이어야 합니다.")
    ;
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return HEAD.message + message;
    }
}
