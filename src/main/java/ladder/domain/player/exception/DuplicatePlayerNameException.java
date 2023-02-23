package ladder.domain.player.exception;

import ladder.common.CustomException;

public class DuplicatePlayerNameException extends CustomException {

    private static final String MESSAGE = "중복되는 이름이 있습니다.";

    public DuplicatePlayerNameException() {
        super(MESSAGE);
    }
}
