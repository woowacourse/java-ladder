package constant;

import static domain.Height.MAX_OF_HEIGHT;
import static domain.Height.MIN_OF_HEIGHT;
import static domain.Name.MAX_OF_NAME_LENGTH;
import static domain.Participants.MAX_OF_PARTICIPANTS_COUNT;
import static domain.Participants.MIN_OF_PARTICIPANTS_COUNT;

public enum Exception {

    EXIT("[ERROR] 잘못된 입력의 반복으로 프로그램을 종료합니다."),
    OUT_OF_RANGE_HEIGHT("[ERROR] 높이는 " + MIN_OF_HEIGHT + "개 이상 "
            + MAX_OF_HEIGHT + "개 이하여야 합니다."),
    NO_NAME("[ERROR] 이름이 없습니다."),
    OUT_OF_RANGE_NAME_LENGTH("[ERROR] 이름의 길이는 " + MAX_OF_NAME_LENGTH + "글자를 초과할 수 없습니다."),
    OUT_OF_RANGE_PARTICIPANTS_COUNT("[ERROR] 참가자는 " + MIN_OF_PARTICIPANTS_COUNT + "명 이상 "
            + MAX_OF_PARTICIPANTS_COUNT + "명 이하여야 합니다."),
    DUPLICATE_PARTICIPANTS("[ERROR] 참가자 이름은 중복될 수 없습니다."),
    NO_LAST_NAME("[ERROR] 마지막 이름이 존재하지 않습니다."),
    NOT_INTEGER("[ERROR] 최대 사다리 높이는 정수여야 합니다.");

    private final String exceptionMessage;

    Exception(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }
}
