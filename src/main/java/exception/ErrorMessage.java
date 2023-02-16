package exception;

public enum ErrorMessage {
    LADDER_HEIGHT_EXCEPTION("사다리의 높이는 1~100 사이여야 합니다."),
    LADDER_HEIGHT_NON_NUMERIC_EXCEPTION("사다리의 높이는 정수형이어야 합니다."),
    USER_NAME_LENGTH_EXCEPTION("유저의 이름은 5자 이하여야 합니다."),
    USER_NAME_BLANK_EXCEPTION("유저의 이름은 공백일 수 없습니다."),
    USER_NAME_NON_ASCII_CHARACTER_EXCEPTION("유저의 이름에 아스키 코드 이외의 문자는 입력하면 안 됩니다."),
    USERS_NAME_BLANK_EXCEPTION("유저의 이름으로 쉼표만 입력하면 안 됩니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
