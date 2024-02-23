package constant.view;

public enum InputViewExceptionMessage {
    NO_LAST_NAME("[ERROR] 마지막 이름이 존재하지 않습니다."),
    NOT_INTEGER("[ERROR] 최대 사다리 높이는 정수여야 합니다.");

    private final String exceptionMessage;

    InputViewExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }
}
