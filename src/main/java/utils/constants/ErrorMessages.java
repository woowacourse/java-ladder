package utils.constants;

public enum ErrorMessages {
    NAME_LENGTH("이름은 1글자 이상 5글자 이하여야 합니다."),
    NUMBER_FORMAT("1 이상 10 이하의 정수만 입력가능합니다."),
    DUPLICATED_INPUT("중복된 값은 입력할 수 없습니다."),
    CONSECUTIVE_LINE("사다리의 라인은 같은 깊이에서 연속적으로 존재할 수 없습니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
