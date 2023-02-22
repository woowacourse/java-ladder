package ladder.error;

public enum ErrorMessage {
    DUPLICATE_NAMES("이름은 중복일 수 없습니다."),
    NON_NUMERIC("사다리 높이는 숫자여야 합니다."),
    NAME_IS_NULL("null은 이름으로 설정할 수 없습니다."),
    NAME_IS_NOT_EXIST("존재하지 않는 참여자 이름입니다."),
    INVALID_HEIGHT_RANGE("사다리 높이는 1이상, 10000 이하여야 합니다."),
    INVALID_NAME_LENGTH("이름은 1글자 이상, 5글자 이하여야 합니다."),
    INVALID_NAME_FORMAT("이름에 쉼표(,)를 포함할 수 없습니다."),
    INVALID_PEOPLE_COUNT("참여자는 2명 이상 100명 이하여야 합니다."),
    INVALID_BET_LENGTH("내기는 1글자 이상, 5글자 이하여야 합니다."),
    INVALID_BET_FORMAT("내기에 쉼표(,)를 포함할 수 없습니다."),
    UNAVAILABLE_NAME("참여자 이름은 'all'일 수 없습니다."),
    BET_IS_NULL("null은 내기로 설정할 수 없습니다."),
    DIFFERENT_PARTICIPANTS_AND_BETS_COUNT("참여자 수와 내기의 수가 일치하지 않습니다.");

    private static final String ERROR_FORMAT = "[ERROR] %s";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(ERROR_FORMAT, message);
    }
}
