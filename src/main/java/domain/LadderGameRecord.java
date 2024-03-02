package domain;

import domain.ladder.Ladder;
import domain.player.Player;
import domain.player.Players;
import domain.result.Result;
import domain.result.Results;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGameRecord {

    private final Players players;
    private final Ladder ladder;
    private final Results results;

    public LadderGameRecord(Players players, Ladder ladder, Results results) {
        this.players = players;
        this.ladder = ladder;
        this.results = results;
    }

    public Map<Player, Result> getAllPlayerResults() {
        Map<Player, Result> playerResult = new LinkedHashMap<>();

        for (int start = 0; start < players.getPlayerSize(); start++) {
            int end = ladder.climb(start);
            Player player = players.getPlayers().get(start);
            Result result = results.getResults().get(end);
            playerResult.put(player, result);
        }

        return playerResult;
    }

    public Result getOnePlayerResult(String playerName) {
        int start = players.getStartPositionOf(playerName);
        int end = ladder.climb(start);

        return results.getResults().get(end);
    }
}
