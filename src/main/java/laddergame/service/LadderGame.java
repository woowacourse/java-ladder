package laddergame.service;

import laddergame.domain.BooleanGenerator;
import laddergame.domain.Ladder;
import laddergame.domain.LadderHeight;
import laddergame.domain.LineSize;
import laddergame.domain.Names;
import laddergame.domain.Result;

public class LadderGame {

    private final BooleanGenerator booleanGenerator;

    public LadderGame(final BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
    }

    public Result createLadder(final Names names, final LadderHeight height) {
        final LineSize lineSize = new LineSize(names);
        final Ladder ladder = Ladder.create(lineSize, height, booleanGenerator);

        return Result.of(names, ladder);
    }
}
