package ladder.domain;

import java.util.Collections;
import java.util.List;

public class LadderLevel {

    private final List<LadderDirection> ladderLevel;

    public LadderLevel(List<LadderDirection> ladderDirections) {
        ladderLevel = ladderDirections;
    }

    public List<LadderDirection> toLadderDirectionList() {
        return Collections.unmodifiableList(ladderLevel);
    }
}
