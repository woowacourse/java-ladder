package ladder.domain;

import java.util.Collections;
import java.util.List;

public class LadderStep {
    private final List<Boolean> ladderPaths;

    public LadderStep(final List<Boolean> ladderPaths) {
        this.ladderPaths = Collections.unmodifiableList(ladderPaths);
    }
}
