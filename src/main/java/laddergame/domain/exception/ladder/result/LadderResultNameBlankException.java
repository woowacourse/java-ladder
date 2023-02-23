package laddergame.domain.exception.ladder.result;

import laddergame.domain.exception.BlankException;

public class LadderResultNameBlankException extends BlankException {
    private static final String LADDER_RESULT_NAME = "사다리 결과 이름은";

    public LadderResultNameBlankException() {
        super(LADDER_RESULT_NAME);
    }
}
