package domain;

public enum ErrorMessages {
    NAME_LENGTH("이름은 1글자 이상 5글자 이하여야 합니다."),
    CONFLICT_NAME("ALL 과 QUIT은 이름으로 사용할 수 없습니다."),
    REWARD_LENGTH("상품 이름은 1글자 이상 5글자 이하여야 합니다."),
    NUMBER_FORMAT("1 이상 10 이하의 정수만 입력가능합니다."),
    DUPLICATED_INPUT("중복된 값은 입력할 수 없습니다."),
    DIFFERENT_LENGTH("%d개의 상품만 입력할 수 있습니다."),
    NONE_EXISTED_USER("존재하지 않는 사용자 입니다.");


    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
