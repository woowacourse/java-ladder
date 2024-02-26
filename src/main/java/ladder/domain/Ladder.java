package ladder.domain;

import java.util.Collections;
import java.util.Map;

public class Ladder {
    private final Map<Integer, Paths> paths;

    private Ladder(final Map<Integer, Paths> paths) {
        this.paths = paths;
    }

    public static Ladder of(LadderHeight ladderHeight, int playersCount) {
        return new Ladder(Collections.emptyMap());
    }
}
