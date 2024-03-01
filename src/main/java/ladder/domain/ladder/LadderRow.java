package ladder.domain.ladder;

import java.util.Collections;
import java.util.List;

import ladder.domain.ladder.direction.LadderDirection;

public class LadderRow {

    private final List<LadderDirection> ladderRow;

    private LadderRow(final List<LadderDirection> ladderDirections) {
        ladderRow = ladderDirections;
    }

    public static LadderRow from(final List<LadderDirection> ladderDirections) {
        return new LadderRow(ladderDirections);
    }

    public LadderDirection getLadderDirection(final int index) {
        return ladderRow.get(index);
    }

    public List<LadderDirection> getLadderDirections() {
        return Collections.unmodifiableList(ladderRow);
    }
}
