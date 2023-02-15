package ladder.error;

public enum ErrorMessage {
    DUPLICATION("이름은 중복일 수 없습니다."),
    NON_NUMERIC("사다리 높이는 숫자여야 합니다."),
    INVALID_HEIGHT_RANGE("사다리 높이는 1이상, 10000 이하여야 합니다."),
    INVALID_NAME_LENGTH("이름은 1글자 이상, 5글자 이하여야 합니다."),
    INVALID_NAME_FORMAT("이름에 쉼표(,)를 포함할 수 없습니다."),
    NAME_IS_NULL("null은 이름으로 설정할 수 없습니다.");

    private static final String ERROR_FORMAT = "[ERROR]: %s";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(ERROR_FORMAT, message);
    }
}
