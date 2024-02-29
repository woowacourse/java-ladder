package ladder.domain.ladder;

import ladder.domain.Direction;
import ladder.domain.Position;

import java.util.List;

import static java.util.Collections.unmodifiableList;
import static ladder.domain.ladder.Path.EMPTY;

public class LadderStep {
    private static final int ALWAYS_VALID_PATH_ORDER = 0;

    private final List<Path> ladderPaths;

    public LadderStep(final List<Path> ladderPaths) {
        final List<Path> discontinuousLadderPaths = correctToDiscontinuousLadderPaths(ladderPaths);
        this.ladderPaths = unmodifiableList(discontinuousLadderPaths);
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
        final Path currentPath = ladderPaths.get(pathOrder);
        final Path prevPath = ladderPaths.get(pathOrder - 1);
        if (currentPath.isExist() && prevPath.isExist()) {
            ladderPaths.set(pathOrder, EMPTY);
        }
    }

    public Direction getNextDirection(final Position currentPosition) {
        final int position = currentPosition.value();
        if (isLeftPathExistOn(position)) {
            return Direction.LEFT;
        }
        if (isRightPathExistOn(position)) {
            return Direction.RIGHT;
        }
        return Direction.NEUTRAL;
    }

    private boolean isLeftPathExistOn(final int position) {
        return position > 0 && isPathExistOn(position - 1);
    }

    private boolean isRightPathExistOn(final int position) {
        return position < ladderPaths.size() && isPathExistOn(position);
    }

    private boolean isPathExistOn(final int position) {
        final Path path = ladderPaths.get(position);
        return path.isExist();
    }

    public List<Path> getLadderPaths() {
        return ladderPaths;
    }
}
