package constant.domain;

import static domain.Participants.MAX_OF_PARTICIPANTS_COUNT;
import static domain.Participants.MIN_OF_PARTICIPANTS_COUNT;

public enum ParticipantsExceptionMessage {

    OUT_OF_RANGE_PARTICIPANTS_COUNT("[ERROR] 참가자는 " + MIN_OF_PARTICIPANTS_COUNT + "명 이상 "
            + MAX_OF_PARTICIPANTS_COUNT + "명 이하여야 합니다."),
    DUPLICATE_PARTICIPANTS("[ERROR] 참가자 이름은 중복될 수 없습니다.");

    private final String exceptionMessage;

    ParticipantsExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }
}
