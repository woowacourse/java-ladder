package laddergame.constant;

public enum ErrorMessage {
    PLAYER_NAME_DUPLICATED("플레이어 이름이 중복되었습니다."),
    NOT_NATURAL_NUMBER("자연수를 입력해 주세요."),
    NOT_VALID_PLAYER_NAME("플레이어 이름은 공백이 아닌 5글자 이하여야 합니다"),
    NOT_VALID_PLAYER_COUNT("2명 이상의 플레이어가 필요합니다."),
    EMPTY_INPUT("공백을 입력할 수 없습니다."),
    NOT_VALID_ARGUMENT("올바른 값이 아닙니다.");

    private final String ERROR_MARKER = "[ERROR]";
    private final String SPACE = " ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_MARKER + SPACE + message;
    }
}
