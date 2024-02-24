package exception.domain;

import static domain.Height.MAX_OF_HEIGHT;
import static domain.Height.MIN_OF_HEIGHT;
import static domain.Name.MAX_OF_NAME_LENGTH;
import static domain.Participants.MAX_OF_PARTICIPANTS_COUNT;
import static domain.Participants.MIN_OF_PARTICIPANTS_COUNT;

public enum HeightExceptionMessage {

    OUT_OF_RANGE_HEIGHT("[ERROR] 높이는 " + MIN_OF_HEIGHT + "개 이상 "
            + MAX_OF_HEIGHT + "개 이하여야 합니다.");

    private final String exceptionMessage;

    HeightExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }
}
