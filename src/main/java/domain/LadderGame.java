package domain;

import java.util.*;

public class LadderGame {

    private static final String ALL_PLAYERS = "all";

    private final Players players;
    private final Ladder ladder;
    private final GameResults gameResults;

    public LadderGame(final Players players, final Ladder ladder, final GameResults gameResults) {
        this.players = players;
        this.ladder = ladder;
        this.gameResults = gameResults;
    }

    public LinkedHashMap<Player, GameResult> getGameResultOf(final String playerName) {
        LinkedHashMap<Player, GameResult> gameResults = new LinkedHashMap<>();
        if (playerName.equals(ALL_PLAYERS)) {
            return getGameResultsOfAllPlayers(gameResults);
        }
        Player player = players.get(playerName);
        gameResults.put(player, this.gameResults.getGameResultAt(ladder.getGameResultOrderOf(player)));
        return gameResults;
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

    private LinkedHashMap<Player, GameResult> getGameResultsOfAllPlayers(LinkedHashMap<Player, GameResult> gameResults) {
        for (Player player : players.get()) {
            gameResults.put(player, this.gameResults.getGameResultAt(ladder.getGameResultOrderOf(player)));
        }
        return gameResults;
    }

}
