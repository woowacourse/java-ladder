package utils.constants;

public enum ErrorMessages {
    ERROR_HEADER("[ERROR] "),
    NAME_LENGTH("이름은 1글자 이상 5글자 이하여야 합니다."),
    NUMBER_FORMAT("정수만 입력가능합니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_HEADER + message;
    }
}
