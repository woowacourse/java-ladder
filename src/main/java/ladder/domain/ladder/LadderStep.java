package ladder.domain.ladder;

import java.util.Collections;
import java.util.List;

public class LadderStep {
    private final List<Path> ladderPaths;

    public LadderStep(final List<Path> ladderPaths) {
        this.ladderPaths = Collections.unmodifiableList(ladderPaths);
    }

    public List<Path> getLadderPaths() {
        return ladderPaths;
    }
}
