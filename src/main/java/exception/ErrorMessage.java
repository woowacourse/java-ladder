package exception;

public enum ErrorMessage {

    LADDER_HEIGHT_EXCEPTION("사다리의 높이는 1~100 사이의 정수여야 합니다."),
    USER_NAME_LENGTH_EXCEPTION("유저의 이름은 5자 이하여야 합니다."),
    USER_NAME_BLANK_EXCEPTION("유저의 이름은 공백일 수 없습니다."),
    USER_NAME_NON_ASCII_CHARACTER_EXCEPTION("아스키 코드 이외의 문자는 입력할 수 없습니다."),
    USER_NAME_IS_ALL_EXCEPTION("유저의 이름으로 'all'을 입력할 수 없습니다."),

    USER_NAMES_BLANK_EXCEPTION("유저의 이름으로 쉼표만 입력하면 안 됩니다."),
    USER_NAME_NOT_EXISTS_IN_USERS_EXCEPTION("해당 이름은 참여자가 아닙니다. 다시 입력해 주세요."),
    RESULT_NAME_LENGTH_EXCEPTION("실행 결과 이름은 8자 이하여야 합니다."),
    RESULT_NAME_BLANK_EXCEPTION("실행 결과 이름은 공백일 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
