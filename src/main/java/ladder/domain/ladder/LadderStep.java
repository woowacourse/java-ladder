package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;
import static ladder.domain.ladder.Path.EMPTY;

public final class LadderStep {
    private final List<Path> ladderPaths;

    public LadderStep(List<Path> ladderPaths) {
        ladderPaths = correctLadderPaths(ladderPaths);
        this.ladderPaths = unmodifiableList(ladderPaths);
    }

    private List<Path> correctLadderPaths(List<Path> ladderPaths) {
        final List<Path> correctedLadderPaths = new ArrayList<>();
        Path prevPath = EMPTY;
        for (Path currentPath: ladderPaths) {
            final Path correctedPath = correctPath(prevPath, currentPath);
            correctedLadderPaths.add(correctedPath);
            prevPath = correctedPath;
        }
        return correctedLadderPaths;
    }

    private Path correctPath(final Path prevPath, final Path currentPath) {
        if(prevPath.equals(EMPTY)) {
            return currentPath;
        }
        return EMPTY;
    }

    public List<Path> getLadderPaths() {
        return ladderPaths;
    }
}
