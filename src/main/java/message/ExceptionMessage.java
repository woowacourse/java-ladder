package message;

public enum ExceptionMessage {
    EXCEPTION_NAME_PATTERN("[ERROR] 이름은 알파벳 대소문자, 한글 로만 구성 가능합니다."),
    EXCEPTION_LADDER_RESULT("[ERROR] 실행 결과는 ,로 구분하며 참여할 사람의 수만큼 입력가능합니다."),
    EXCEPTION_LADDER_HEIGHT("[ERROR] 1 이상, 20이하의 숫자만 입력 가능합니다."),
    EXCEPTION_NAME_LENGTH("[ERROR] 이름은 최대 5글자까지 입력 가능합니다."),
    EXCEPTION_PLAYER_RESULT("[ERROR] 참여하는 사용자 이름만 입력 가능합니다.");

    private final String exceptionMessage;

    ExceptionMessage(String exception) {
        this.exceptionMessage = exception;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

}
