package constant.domain;

public enum ResultExceptionMessage {
    NOT_SAME_COUNT("[ERROR] 결과의 개수가 참여자의 인원수와 다릅니다.");

    private final String exceptionMessage;

    ResultExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }

}
