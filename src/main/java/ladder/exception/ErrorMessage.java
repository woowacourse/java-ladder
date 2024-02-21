package ladder.exception;

import static ladder.domain.ladder.LadderHeight.MINIMUM_HEIGHT;
import static ladder.domain.player.Player.MAXIMUM_NAME_RANGE;
import static ladder.domain.player.Players.MAXIMUM_PLAYER_SIZE;
import static ladder.domain.player.Players.MINIMUM_PLAYER_SIZE;

public enum ErrorMessage {
    INPUT_NOT_A_NUMBER("입력 값은 숫자여야 합니다."),
    INVALID_LADDER_HEIGHT_RANGE(String.format("사다리의 높이는 %d보다 작으면 예외가 발생한다.", MINIMUM_HEIGHT)),
    INVALID_PLAYER_NAME_FORMAT("참가자들의 이름은 영어, 숫자여야 합니다."),
    INVALID_PLAYER_NAME_RANGE(String.format("참가자들의 이름은 %d글자를 초과할 수 없습니다.", MAXIMUM_NAME_RANGE)),
    INVALID_PLAYER_SIZE(String.format("참가자들의 수는 %d~%d여야 합니다.", MINIMUM_PLAYER_SIZE, MAXIMUM_PLAYER_SIZE)),

    DUPLICATED_PLAYER_NAME("참가자들의 이름은 중복될 수 없습니다."),
    INPUT_NOT_BLANK("입력은 비어있을 수 없습니다.");


    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
