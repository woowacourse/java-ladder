package ladder.model;

public enum ErrorMessage {

    EXCEPTION_PLAYER_NAME_DUPLICATE("이름은 중복될 수 없습니다."),
    EXCEPTION_PLAYER_COUNT("플레이어 수는 두 명 이상, 30명 이하여야 합니다."),
    EXCEPTION_PLAYER_NAME_LENGTH("플레이어 이름은 1자 이상 5자 이하여야 합니다."),
    EXCEPTION_PLAYER_NAME_RESTRICTED("플레이어 이름은 all 일 수 없습니다."),
    EXCEPTION_HEIGHT_INVALID_TYPE("정수가 아닙니다."),
    EXCEPTION_HEIGHT("사다리 높이는 2 이상 100 이하여야 합니다."),
    EXCEPTION_REWARD_LENGTH("실행 결과는 1자 이상 5자 이하여야 합니다."),
    EXCEPTION_REWARD_COUNT("실행 결과의 수는 플레이어의 수와 일치해야 합니다.");

    private static final String ERROR_HEADER = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_HEADER + message;
    }

}
