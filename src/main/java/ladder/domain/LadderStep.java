package ladder.domain;

import java.util.Collections;
import java.util.List;

public class LadderStep {
    private final List<PathAvailability> ladderPaths;

    public LadderStep(final List<PathAvailability> ladderPaths) {
        this.ladderPaths = Collections.unmodifiableList(ladderPaths);
    }
}
