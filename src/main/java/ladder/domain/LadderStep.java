package ladder.domain;

import java.util.Collections;
import java.util.List;

public class LadderStep {
    private final List<Path> ladderPaths;

    public LadderStep(final List<Path> ladderPaths) {
        this.ladderPaths = Collections.unmodifiableList(ladderPaths);
    }
}
