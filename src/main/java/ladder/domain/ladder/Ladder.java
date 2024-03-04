package ladder.domain.ladder;

import java.util.Collections;
import java.util.List;

import ladder.domain.ladder.direction.LadderDirection;

public class Ladder {

    private final List<LadderRow> ladder;

    private Ladder(final List<LadderRow> ladder) {
        this.ladder = ladder;
    }

    public static Ladder from(final List<LadderRow> ladder) {
        return new Ladder(ladder);
    }

    public LadderPosition climbDownFrom(final LadderPosition ladderPosition) {
        if (ladderPosition.row() == ladder.size()) {
            return ladderPosition;
        }
        LadderDirection direction = getLadderDirection(ladderPosition.row(), ladderPosition.column());
        LadderPosition nextLadderPosition = ladderPosition.next(direction);
        return climbDownFrom(nextLadderPosition);
    }

    private LadderDirection getLadderDirection(final int row, final int column) {
        LadderRow ladderRow = ladder.get(row);
        return ladderRow.getLadderDirection(column);
    }

    public List<LadderRow> getLadderRows() {
        return Collections.unmodifiableList(ladder);
    }
}
