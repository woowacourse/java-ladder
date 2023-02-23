package exception;

public enum ErrorCode {
    HEAD("[ERROR] "),
    NAME_OUT_OF_RANGE("사람 이름은 %d 글자 ~ %d 글자 사이여야 합니다."),
    NUMBER_NOT_INTEGER("사다리 높이는 2이상 100이하의 정수여야 합니다."),
    NUMBER_UNDER_2("사다리 높이는 2 이상 이어야 합니다."),
    NUMBER_OVER_100("사다리 높이는 100 이하 이어야 합니다."),
    NAME_DUPLICATE("이름은 중복되면 안됩니다."),
    NOT_PLAYER("참여자가 아닙니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
