package ladder.domain.ladder;

import java.util.List;

import static java.util.Collections.unmodifiableList;
import static ladder.domain.ladder.Path.EMPTY;

public record LadderStep(List<Path> ladderPaths) {
    private static final int ALWAYS_VALID_PATH_ORDER = 0;

    public LadderStep {
        final List<Path> discontinuousLadderPaths = correctToDiscontinuousLadderPaths(ladderPaths);
        ladderPaths = unmodifiableList(discontinuousLadderPaths);
    }

    private List<Path> correctToDiscontinuousLadderPaths(final List<Path> ladderPaths) {
        for (int pathOrder = 0; pathOrder < ladderPaths.size(); pathOrder++) {
            correctPath(ladderPaths, pathOrder);
        }
        return ladderPaths;
    }

    private void correctPath(final List<Path> ladderPaths, final int pathOrder) {
        if (pathOrder == ALWAYS_VALID_PATH_ORDER) {
            return;
        }
        Path currentPath = ladderPaths.get(pathOrder);
        Path prevPath = ladderPaths.get(pathOrder - 1);
        if (currentPath.isExist() && prevPath.isExist()) {
            ladderPaths.set(pathOrder, EMPTY);
        }
    }
}
