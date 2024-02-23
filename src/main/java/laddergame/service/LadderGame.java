package laddergame.service;

import laddergame.domain.Ladder;
import laddergame.domain.LadderGenerator;
import laddergame.domain.LadderHeight;
import laddergame.domain.LineSize;
import laddergame.domain.Names;
import laddergame.dto.Result;

public class LadderGame {

    private final LadderGenerator ladderGenerator;

    public LadderGame(final LadderGenerator ladderGenerator) {
        this.ladderGenerator = ladderGenerator;
    }

    public Result createLadder(final Names names, final LadderHeight ladderHeight) {
        final LineSize lineSize = new LineSize(names);
        final Ladder ladder = ladderGenerator.generate(lineSize, ladderHeight);

        return Result.of(names, ladder);
    }
}
