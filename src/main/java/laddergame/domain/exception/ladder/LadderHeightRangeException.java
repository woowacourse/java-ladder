package laddergame.domain.exception.ladder;

import laddergame.domain.exception.RangeException;

public class LadderHeightRangeException extends RangeException {

    private static final String LADDER_HEIGHT = "사다리 높이는";

    public LadderHeightRangeException(final int startRange, final int endRange) {
        super(LADDER_HEIGHT, startRange, endRange);
    }
}
