package laddergame.domain;

import laddergame.exception.LadderGameException;

public class LineSize {

    private final int lineSize;

    public LineSize(final Names names) {
        validateSize(names);
        this.lineSize = names.size() - 1;
    }

    private void validateSize(final Names names) {
        if (names == null || names.size() == 0) {
            throw new LadderGameException("[ERROR] 참가자는 1명 이상이어야 합니다.");
        }
    }

    public int getLineSize() {
        return lineSize;
    }
}
