package exception;

public enum ErrorMessage {

    LADDER_HEIGHT_EXCEPTION("사다리의 높이는 1이상이어야 합니다."),
    LADDER_HEIGHT_NON_NUMERIC_EXCEPTION("사다리의 높이는 정수형이어야 합니다."),
    USER_NAME_LENGTH_EXCEPTION("유저의 이름은 5자 이하여야 합니다."),
    USER_NAME_BLANK_EXCEPTION("유저의 이름은 공백일 수 없습니다."),
    USER_NAME_IS_ALL_EXCEPTION("유저의 이름은 all일 수 없습니다. all을 제외하고 입력해주십시오."),
    USER_NOT_FOUND_EXCEPTION("해당 유저를 찾을 수 없습니다."),
    USERS_NAME_BLANK_EXCEPTION("유저의 이름으로 쉼표만 입력하면 안 됩니다."),
    USERS_NAME_HAS_DUPLICATE("유저의 이름이 중복일 수 없습니다."),
    PRIZES_SIZE_IS_NOT_EQUAL_USERS_SIZE_EXCEPTION("상품의 개수는 참여자의 수와 동일해야 합니다."),
    USER_AND_PRIZE_COUNT_IS_NOT_ONE("단일 유저 또는 상금이 아닙니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
