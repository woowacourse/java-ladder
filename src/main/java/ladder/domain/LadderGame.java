package ladder.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;
    private final Prizes prizes;

    public LadderGame(final Players players, final Ladder ladder, final Prizes prizes) {
        this.players = players;
        this.ladder = ladder;
        this.prizes = prizes;
    }

    public LadderResult getResult() {
        final Map<String, String> result = new LinkedHashMap<>();
        final List<String> playerNames = players.getPlayerNames();

        for (int playerPosition = 0; playerPosition < playerNames.size(); playerPosition++) {
            final int prizePosition = ladder.climb(playerPosition);
            result.put(playerNames.get(playerPosition), prizes.check(prizePosition));
        }
        return new LadderResult(result);
    }
}
