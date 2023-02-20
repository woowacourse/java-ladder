package ladder.model;

public enum ErrorMessage {

    EXCEPTION_PLAYER_NAME_DUPLICATE("이름은 중복될 수 없습니다."),
    EXCEPTION_PLAYER_COUNT_MINIMUM("게임을 진행하기 위해서는 두 명 이상의 플레이어가 필요합니다."),
    EXCEPTION_PLAYER_NAME_LENGTH("플레이어 이름은 1자 이상 5자 이하여야 합니다."),
    EXCEPTION_HEIGHT_INVALID_TYPE("정수가 아닙니다."),
    EXCEPTION_HEIGHT_MINIMUM("사다리 높이는 2 이상이어야 합니다.");

    private static final String ERROR_HEADER = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_HEADER+message;
    }

}
