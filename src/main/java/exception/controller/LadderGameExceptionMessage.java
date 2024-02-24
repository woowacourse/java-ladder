package exception.controller;

public enum LadderGameExceptionMessage {

    EXIT("[ERROR] 잘못된 입력의 반복으로 프로그램을 종료합니다.");

    private final String exceptionMessage;

    LadderGameExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }
}
