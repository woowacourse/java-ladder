package model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private final Players players;
    private final Results results;

    public LadderGame(List<String> results, List<String> playersInput) {
        this.players = new Players(playersInput);
        this.results = new Results(results, players.numberOfPlayer());
    }

    public Map<String, String> gameResult(Ladder ladder) {
        Map<String, String> gameResult = new LinkedHashMap<>();
        for (int i = 0; i < players.numberOfPlayer(); i++) {
            String playerName = players.findNameByIndex(i);
            String result = results.responseResult(ladder.calculateResultIndex(i));
            gameResult.put(playerName, result);
        }
        return gameResult;
    }

    public int numberOfPlayer() {
        return players.numberOfPlayer();
    }

    public List<String> getPlayers() {
        return players.getPlayersName();
    }
}
