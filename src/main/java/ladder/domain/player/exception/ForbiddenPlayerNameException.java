package ladder.domain.player.exception;

import ladder.common.CustomException;

public class ForbiddenPlayerNameException extends CustomException {

    private static final String MESSAGE = "플레이어의 이름은 'all'이 될 수 없습니다.";
    public ForbiddenPlayerNameException() {
        super(MESSAGE);
    }
}
