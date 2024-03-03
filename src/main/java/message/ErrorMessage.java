package message;

public enum ErrorMessage {

    INVALID_LADDER_HEIGHT_EXCEPTION("사다리 높이는 1이상 이어야 합니다."),
    INVALID_LADDER_HEIGHT_LANGUAGE_EXCEPTION("사다리 높이는 숫자여야 합니다."),
    NO_PLAYER_NAME_EXCEPTION("플레이어 이름을 입력해야 합니다."),
    INVALID_PLAYER_NAME_LANGUAGE_EXCEPTION("플레이어 이름은 영어여야 합니다."),
    INVALID_PLAYER_NAME_SIZE_EXCEPTION("플레이어 이름은 5자 이하여야 합니다."),
    INVALID_PLAYER_COUNT_EXCEPTION("플레이어의 숫자는 2명 이상이어야 합니다."),
    OVERLAP_PAYER_NAME_EXCEPTION("플레이어 이름이 중복되었습니다."),
    NO_REWARD_NAME_EXCEPTION("보상을 입력해야 합니다."),
    NOT_EQUAL_REWARD_PLAYER_COUNT_EXCEPTION("보상과 플레리어의 수가 다릅니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[Error] " + message;
    }
}
