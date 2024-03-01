package ladder.domain;

import java.util.Collections;
import java.util.List;

public class LadderRow {

    private final List<LadderDirection> ladderRow;

    public LadderRow(List<LadderDirection> ladderDirections) {
        ladderRow = ladderDirections;
    }

    public LadderDirection getLadderDirection(int index) {
        return ladderRow.get(index);
    }

    public List<LadderDirection> getLadderDirections() {
        return Collections.unmodifiableList(ladderRow);
    }
}
