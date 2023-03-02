package ladder.domain.player.exception;

import ladder.common.CustomException;

public class NoSuchPlayerException extends CustomException {

    private static final String MESSAGE = "존재하지 않는 플레이어 입니다.";

    public NoSuchPlayerException() {
        super(MESSAGE);
    }
}
