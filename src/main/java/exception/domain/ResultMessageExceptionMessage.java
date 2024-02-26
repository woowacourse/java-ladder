package exception.domain;

import static domain.ResultMessage.MAX_OF_RESULT_MESSAGE_LENGTH;

public enum ResultMessageExceptionMessage {

    OUT_OF_RANGE_RESULT_MESSAGE_LENGTH("[ERROR] 실행 결과의 길이는 " + MAX_OF_RESULT_MESSAGE_LENGTH + "글자를 초과할 수 없습니다.");

    private final String exceptionMessage;

    ResultMessageExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }
}
