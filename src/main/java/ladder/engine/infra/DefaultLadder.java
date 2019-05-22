package ladder.engine.infra;

import ladder.engine.Ladder;
import ladder.engine.LadderLine;
import ladder.engine.LadderResult;

import java.util.List;

public class DefaultLadder implements Ladder {
    private final List<LadderLine> lines;

    public DefaultLadder(final List<LadderLine> lines) {
        this.lines = lines;
    }

    @Override
    public LadderResult play() {
        return null;
    }
}
