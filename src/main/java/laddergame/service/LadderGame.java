package laddergame.service;

import laddergame.domain.point.PointGenerator;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.ladder.LineSize;
import laddergame.domain.player.Players;

public class LadderGame {

    private final PointGenerator pointGenerator;

    public LadderGame(final PointGenerator pointGenerator) {
        this.pointGenerator = pointGenerator;
    }

    public Ladder createLadder(final Players players, final LadderHeight height) {
        final LineSize lineSize = new LineSize(players);
        final Ladder ladder = Ladder.create(lineSize, height, pointGenerator);

        return ladder;
    }
}
