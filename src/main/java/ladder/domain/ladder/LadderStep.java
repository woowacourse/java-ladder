package ladder.domain.ladder;

import java.util.List;

import static java.util.Collections.unmodifiableList;

public record LadderStep(List<Path> ladderPaths) {
    public LadderStep {
        ladderPaths = unmodifiableList(ladderPaths);
    }
}
