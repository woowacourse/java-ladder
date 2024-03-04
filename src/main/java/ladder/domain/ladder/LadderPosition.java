package ladder.domain.ladder;

import ladder.domain.ladder.direction.LadderDirection;

public record LadderPosition(int row, int column) {

    public static final int START_ROW = 0;

    public LadderPosition(final int column) {
        this(START_ROW, column);
    }

    public LadderPosition next(final LadderDirection direction) {
        return new LadderPosition(row + 1, column + direction.getValue());
    }
}
