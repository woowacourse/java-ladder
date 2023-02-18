package exception;

public enum ErrorCode {
    HEAD("[ERROR] "),
    NAME_OUT_OF_RANGE("사람 이름은 %d 글자 ~ %d 글자 사이여야 합니다."),
    NUMBER_NOT_INTEGER("사다리 높이는 정수 값만 입력 가능합니다."),
    NEGATIVE_NUMBER("사다리 높이는 2 이상 이어야 합니다."),
    NAME_DUPLICATE("이름은 중복되면 안됩니다."),
    EMPTY_INPUT("빈 값은 입력할 수 없습니다.")
    ;
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
