package domain;

public enum ExceptionType {
    HEIGHT_RANGE("높이는 5이상 10 이하여야 합니다."),
    WIDTH_RANGE("폭은 2이상 10 이하여야 합니다."),
    NAME_CHARACTER("이름은 알파벳 대소문자로만 이루어져있어야 합니다."),
    NAME_BLACK_LIST("사용할 수 없는 이름입니다."),
    NAME_LENGTH_RANGE("이름의 길이는 1자 이상 5자 이하여야 합니다."),
    NAMES_COUNT("사람은 최대 10명까지 받을 수 있습니다."),
    NAMES_DUPLICATE("이름은 중복될 수 없습니다."),
    NAMES_SEPARATOR("구분자가 맨 앞이나 맨 뒤에 있으면 안됩니다."),
    ROW_COUNT("가로 라인 개수는 1이상 9 이하여야 합니다."),
    ROW_NEAR("연속해서 가로 라인이 등장할 수 없습니다."),
    RESULTS_COUNT_RANGE("실행 결과는 최대 10개까지 받을 수 있습니다."),
    RESULT_COUNT("실행 결과의 개수와 이름의 개수가 다릅니다."),
    RESULTS_SEPARATOR("구분자가 맨 앞이나 맨 뒤에 있으면 안됩니다."),
    RESULT_LENGTH("실행 결과의 길이는 1자 이상 5자 이하여야 합니다."),
    NAME_NOT_FOUND("없는 이름입니다.");

    private final String message;

    ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
