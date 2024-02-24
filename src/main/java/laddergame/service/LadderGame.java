package laddergame.service;

import laddergame.domain.point.PointGenerator;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.ladder.LineSize;
import laddergame.domain.name.Names;
import laddergame.dto.GameResultDto;

public class LadderGame {

    private final PointGenerator pointGenerator;

    public LadderGame(final PointGenerator pointGenerator) {
        this.pointGenerator = pointGenerator;
    }

    public GameResultDto createLadder(final Names names, final LadderHeight height) {
        final LineSize lineSize = new LineSize(names);
        final Ladder ladder = Ladder.create(lineSize, height, pointGenerator);

        return GameResultDto.of(names, ladder);
    }
}
