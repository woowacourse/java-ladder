package ladder.domain.ladder;

import java.util.List;

import static java.util.Collections.unmodifiableList;

public record LadderStep(List<Path> ladderPaths) {
    @Override
    public List<Path> ladderPaths() {
        return unmodifiableList(ladderPaths);
    }
}
