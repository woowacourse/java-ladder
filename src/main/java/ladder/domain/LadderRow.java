package ladder.domain;

import java.util.Collections;
import java.util.List;

public class LadderRow {

    private final List<LadderDirection> ladderLevel;

    public LadderRow(List<LadderDirection> ladderDirections) {
        ladderLevel = ladderDirections;
    }

    public LadderDirection getLadderDirection(int index) {
        return ladderLevel.get(index);
    }

    public List<LadderDirection> getLadderDirections() {
        return Collections.unmodifiableList(ladderLevel);
    }
}
