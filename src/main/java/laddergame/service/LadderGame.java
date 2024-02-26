package laddergame.service;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderGenerator;
import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.ladder.LineSize;
import laddergame.domain.name.Names;
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
