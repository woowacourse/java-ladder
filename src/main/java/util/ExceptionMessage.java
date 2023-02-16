package util;

public enum ExceptionMessage {
    EXCEPTION_NAME_PATTERN("[ERROR] 이름은 알파벳 대소문자로만 구성 가능합니다."),
    EXCEPTION_LADDER_HEIGHT("[ERROR] 1 이상의 숫자만 입력 가능합니다.");


    private final String exceptionMessage;

    ExceptionMessage(String exception) {
        this.exceptionMessage = exception;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

}
