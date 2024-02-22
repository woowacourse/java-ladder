package laddergame.service;

import laddergame.domain.PointGenerator;
import laddergame.domain.Ladder;
import laddergame.domain.LadderHeight;
import laddergame.domain.LineSize;
import laddergame.domain.Names;
import laddergame.domain.Result;

public class LadderGame {

    private final PointGenerator pointGenerator;

    public LadderGame(final PointGenerator pointGenerator) {
        this.pointGenerator = pointGenerator;
    }

    public Result createLadder(final Names names, final LadderHeight height) {
        final LineSize lineSize = new LineSize(names);
        final Ladder ladder = Ladder.create(lineSize, height, pointGenerator);

        return Result.of(names, ladder);
    }
}
