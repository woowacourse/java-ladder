package ladder.domain.result.exception;

import ladder.common.CustomException;

public class ResultNumberException extends CustomException {

    private static final String MESSAGE = "결과 목록 수는 플레이어 수와 같아야 합니다.";

    public ResultNumberException() {
        super(MESSAGE);
    }
}
