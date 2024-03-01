package ladder.domain;

import java.util.Collections;
import java.util.List;

public class LadderRow {

    private final List<LadderDirection> ladderRow;

    private LadderRow(List<LadderDirection> ladderDirections) {
        ladderRow = ladderDirections;
    }

    public static LadderRow from(List<LadderDirection> ladderDirections) {
        return new LadderRow(ladderDirections);
    }

    public LadderDirection getLadderDirection(int index) {
        return ladderRow.get(index);
    }

    public List<LadderDirection> getLadderDirections() {
        return Collections.unmodifiableList(ladderRow);
    }
}
