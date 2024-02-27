package laddergame.service;

import laddergame.domain.result.Result;
import laddergame.domain.point.PointGenerator;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.ladder.LineSize;
import laddergame.domain.player.Players;
import laddergame.domain.result.Trace;
import laddergame.domain.target.Target;
import laddergame.domain.target.Targets;

import java.util.HashMap;
import java.util.Map;

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

    public Result start(final Players players, final Ladder ladder, final Targets targets) {
        Map<String, String> map = new HashMap<>();

        for (int i=0; i< players.getSize(); i++) {
            Trace trace = ladder.move(i);
            Target target = targets.convertToTarget(trace);

            map.put(players.getPlayerName(i), target.getTarget());
        }

        return new Result(map);
    }
}
