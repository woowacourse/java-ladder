package ladder.domain.result.exception;

import ladder.common.CustomException;

public class ResultNameLengthException extends CustomException {

    private static final String MESSAGE = "결과 이름의 길이는 1이상 5이하 입니다.";

    public ResultNameLengthException() {
        super(MESSAGE);
    }
}
