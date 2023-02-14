package exception;

public enum ErrorCode {
    HEAD("[ERROR] "),
    NAME_OUT_OF_RANGE("사람 이름은 %d 글자 ~ %d 글자 사이여야 합니다."),
    ;
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
