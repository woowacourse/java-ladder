package constant.domain;

public enum PrizeExceptionMessage {
    NO_PRIZE("[ERROR] 결과가 없습니다.");

    private final String exceptionMessage;

    PrizeExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }
}
