package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public int findNextParticipantPosition(final int participantPosition) {
        Optional<Integer> leftPathPosition = getLeftPosition(participantPosition);
        if (leftPathPosition.isPresent()) {
            return leftPathPosition.get();
        }
        Optional<Integer> rightPathPosition = getRightPosition(participantPosition);
        return rightPathPosition.orElse(participantPosition);
    }

    private Optional<Integer> getLeftPosition(final int position) {
        if (position > 0 && isExistIn(position - 1)) {
            return Optional.of(position - 1);
        }
        return Optional.empty();
    }

    private Optional<Integer> getRightPosition(final int position) {
        if (position < ladderPaths.size() && isExistIn(position)) {
            return Optional.of(position + 1);
        }
        return Optional.empty();
    }

    private boolean isExistIn(final int position) {
        return ladderPaths.get(position).isExist();
    }

    public List<Path> getLadderPaths() {
        return ladderPaths;
    }
}
