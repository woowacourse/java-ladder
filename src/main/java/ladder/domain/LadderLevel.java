package ladder.domain;

import java.util.Collections;
import java.util.List;

public class LadderLevel {

    private final List<Direction> ladderLevel;

    public LadderLevel(List<Direction> directions) {
        ladderLevel = directions;
    }

    public List<Direction> toDirectionList() {
        return Collections.unmodifiableList(ladderLevel);
    }
}
