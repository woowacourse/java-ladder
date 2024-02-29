package constant.domain;

public enum MatchResultExceptionMessage {
    NO_MATCHING_NAME("[ERROR] 존재하지 않는 사용자입니다.");

    private final String exceptionMessage;

    MatchResultExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }
}
