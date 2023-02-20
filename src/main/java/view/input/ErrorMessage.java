package view.input;

public enum ErrorMessage {
    EMPTY_INPUT("입력값이 없습니다. 다시 입력해주세요"),
    INVALID_LINE_WEIGHT("사다리의 라인은 1개에서 9개까지 생성 될 수 있습니다.(참가자가 10명 이하여야 합니다.)"),
    INVALID_LADDER_HEIGHT("사다리의 높이는 1이상 10이하의 숫자입니다. 다시 입력해주세요."),
    INVALID_PARTICIPANT_COUNT("참가자는 1명이상 10이하입니다. 다시 입력해주세요."),
    INVALID_PERSON_NAME("참가자의 이름은 1이상 5이하입니다. 다시 입력해주세요."),
    DUPLICATE_NAME("중복되는 이름이 존재합니다. 다시 입력해주세요");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
