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
        if (isLastRow(ladderPosition)) {
            return ladderPosition;
        }
        LadderDirection direction = getLadderDirectionAt(ladderPosition);
        LadderPosition nextLadderPosition = ladderPosition.next(direction);
        return climbDownFrom(nextLadderPosition);
    }

    private boolean isLastRow(final LadderPosition ladderPosition) {
        return ladderPosition.row() == ladder.size();
    }

    private LadderDirection getLadderDirectionAt(final LadderPosition ladderPosition) {
        LadderRow ladderRow = ladder.get(ladderPosition.row());
        return ladderRow.getLadderDirection(ladderPosition.column());
    }

    public List<LadderRow> getLadderRows() {
        return Collections.unmodifiableList(ladder);
    }
}
