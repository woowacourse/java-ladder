package ladder.domain.ladder;

import ladder.domain.ladder.direction.LadderDirection;

public class LadderPosition {

    public static final int START_ROW = 0;

    private final int row;
    private final int column;

    private LadderPosition(final int row, final int column) {
        this.row = row;
        this.column = column;
    }

    public LadderPosition(final int column) {
        this(START_ROW, column);
    }

    public LadderPosition next(final LadderDirection direction) {
        return new LadderPosition(row + 1, column + direction.getValue());
    }

    public int row() {
        return row;
    }

    public int column() {
        return column;
    }
}
