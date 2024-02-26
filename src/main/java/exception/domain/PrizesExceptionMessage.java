package exception.domain;

import static domain.Prizes.MAX_OF_PRIZE_LENGTH;

public enum PrizesExceptionMessage {

    OUT_OF_RANGE_PRIZE_LENGTH("[ERROR] 실행 결과의 길이는 " + MAX_OF_PRIZE_LENGTH + "글자를 초과할 수 없습니다."),
    NO_PRIZE("[ERROR] 실행 결과가 없습니다.");

    private final String exceptionMessage;

    PrizesExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }
}
