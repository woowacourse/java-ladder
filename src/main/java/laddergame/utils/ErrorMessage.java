package laddergame.utils;

public enum ErrorMessage {

    INVALID_USER_NAME_LENGTH("이름의 길이는 %d 이상 %d 이하여야 합니다."),
    INVALID_USER_NAME_FORMAT("이름에는 공백이 포함될 수 없습니다."),
    INVALID_USER_NAME_ALL("\"all\"은 사용자 이름으로 등록할 수 없습니다."),

    NOT_FOUND_USER("유저가 존재하지 않습니다."),

    INVALID_LADDER_HEIGHT_RANGE("사다리의 높이는 %d 이상입니다."),
    INVALID_LADDER_HEIGHT_INPUT("사다리의 높이는 숫자만 입력 가능합니다."),

    INVALID_GAME_RESULT_LENGTH("게임 결과의 길이는 %d 이상 %d 이하여야 합니다."),
    INVALID_GAME_RESULTS_SIZE("사다리 게임에서 당첨될 수 있는 결과의 수는 사용자의 수와 같아야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
