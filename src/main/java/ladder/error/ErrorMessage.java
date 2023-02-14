package ladder.error;

public enum ErrorMessage {
    DUPLICATION("이름은 중복일 수 없습니다."),
    NON_NUMERIC("사다리 높이는 숫자여야 합니다.");

    private static final String ERROR_FORMAT = "[ERROR]: %s";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(ERROR_FORMAT, message);
    }
}
