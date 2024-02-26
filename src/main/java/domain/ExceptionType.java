package domain;

public enum ExceptionType {
    INVALID_HEIGHT_RANGE("높이는 5이상 10 이하여야 합니다."),
    INVALID_WIDTH_RANGE("폭은 2이상 10 이하여야 합니다."),
    INVALID_NAME_CHARACTER("이름은 알파벳 대소문자로만 이루어져있어야 합니다."),
    INVALID_NAME_LENGTH_RANGE("이름의 길이는 1자 이상 5자 이하여야 합니다."),
    INVALID_NAMES_RANGE("사람은 최소 2명 최대 10명까지 받을 수 있습니다."),
    INVALID_SEPARATOR_POSITION("구분자가 맨 앞이나 맨 뒤에 있으면 안됩니다."),
    INVALID_BRIDGES_RANGE("다리 개수는 1이상 9 이하여야 합니다."),
    NOT_ALLOW_DUPLICATE_NAME("이름은 중복될 수 없습니다."),
    NOT_ALLOW_NEAR_BRIDGE("근처에 다리가 있으면 놓을 수 없습니다."),
    INVALID_LADDER_RESULT_RANGE("사다리 결과 길이는 1자 이상 5자 이하여야 합니다."),
    INVALID_LADDER_RESULTS_RANGE("사다리 결과 개수는 최소 2개 최대 10개까지 받을 수 있습니다."),
    INVALID_LADDER_RESULT_CHARACTER("사다리 결과는 공백이 포함될 수 없습니다.");

    private final String message;

    ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
