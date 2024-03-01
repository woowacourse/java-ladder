package ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {

    private final Ladder ladder;
    private final Players players;
    private final LadderResults ladderResults;

    public LadderGame(final Players players, final LadderResults ladderResults, final Ladder ladder) {
        this.ladder = ladder;
        this.players = players;
        this.ladderResults = ladderResults;
    }

    public Map<Player, LadderResult> play() {
        Map<Player, LadderResult> results = new LinkedHashMap<>();
        players.players().forEach(player -> {
            LadderPosition start = new LadderPosition(0, players.orderOf(player));
            LadderPosition end = ladder.climbFrom(start);
            results.put(player, ladderResults.get(end.column()));
        });
        return results;
    }

    public Ladder ladder() {
        return ladder;
    }

    public Players players() {
        return players;
    }

    public LadderResults ladderResults() {
        return ladderResults;
    }
}
