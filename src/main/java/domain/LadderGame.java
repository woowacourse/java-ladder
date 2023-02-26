package domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;
    private final GameResults gameResults;

    public LadderGame(final Players players, final Ladder ladder, final GameResults gameResults) {
        this.players = players;
        this.ladder = ladder;
        this.gameResults = gameResults;
    }

    public GameResult getGameResultOf(final String playerName) {
        Player player = players.get(playerName);
        return gameResults.getGameResultAt(ladder.getGameResultOf(player));
    }

    public LinkedHashMap<String, GameResult> getGameResultsOfAllPlayers() {
        LinkedHashMap<String, GameResult> results = new LinkedHashMap<>();
        for (Player player : players.get()) {
            results.put(player.getName(), getGameResultOf(player.getName()));
        }
        return results;
    }

    public List<String> getPlayerNames() {
        return Collections.unmodifiableList(players.getPlayerNames());
    }

    public GameResults getGameResults() {
        return gameResults;
    }

    public Ladder getLadder() {
        return ladder;
    }

}
