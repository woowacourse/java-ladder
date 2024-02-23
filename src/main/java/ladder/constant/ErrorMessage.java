package ladder.constant;

public enum ErrorMessage {
    CONTINUE_SCAFFOLD("좌우 연속해서 발판이 존재할 수 없습니다."),
    MIN_LADDER_HEIGHT("사다리의 높이는 1 이상의 정수이어야 합니다."),
    MIN_PEOPLE_COUNT("사다리 게임에 참여하는 사람의 수는 2명 이상 이여야 합니다."),
    MAX_PERSON_NAME_LENGTH("사람 이름의 길이는 5자를 넘을 수 없습니다."),
    PERSON_NAME_NOT_BLANK("사람 이름의 비어있거나 공백일 수 없습니다."),
    PEOPLE_NAMES_STARTS_OR_ENDS_WITH_DELIMITER("사람들의 이름은 콤마(,)로 시작하거나 끝날 수 없습니다."),
    LADDER_HEIGHT_NUMBER_FORMAT("사다리의 높이는 숫자이어야 합니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String generate() {
        return PREFIX + message;
    }
}
