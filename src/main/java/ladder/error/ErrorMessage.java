package ladder.error;

public enum ErrorMessage {
    DUPLICATION("이름은 중복일 수 없습니다."),
    NON_NUMERIC("사다리 높이는 숫자여야 합니다."),
    NAME_IS_NULL("null은 이름으로 설정할 수 없습니다."),
    INVALID_HEIGHT_RANGE("사다리 높이는 1이상, 10000 이하여야 합니다."),
    INVALID_NAME_LENGTH("이름은 1글자 이상, 5글자 이하여야 합니다."),
    INVALID_NAME_FORMAT("이름에 쉼표(,)를 포함할 수 없습니다."),
    INVALID_PEOPLE_COUNT("참여자는 2명 이상 100명 이하여야 합니다."),
    ALL_SAME_RESULTS("실행 결과가 모두 같을 수 없습니다."),
    INVALID_RESULT_FORMAT("결과에 쉼표(,)를 포함할 수 없습니다."),
    INVALID_RESULT_LENGTH("결과는 5글자 이하여야 합니다."),
    RESULT_IS_NULL("null은 결과로 설정할 수 없습니다."),
    INVALID_NUMBER_OF_RESULTS("실행결과의 수가 참여자의 수와 다릅니다."),
    INVALID_NAME_WANT_TO_KNOW_RESULT("참여자 중에 해당하는 이름이 없습니다."),
    NAME_IS_ALL("이름이 all이신 경우, All로 입력해주세요.");

    private static final String ERROR_FORMAT = "[ERROR] %s";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(ERROR_FORMAT, message);
    }
}
