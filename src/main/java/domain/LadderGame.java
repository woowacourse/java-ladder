package domain;

import java.util.*;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;
    private final GameResults gameResults;

    public LadderGame(final Players players, final Ladder ladder, final List<String> gameResultNames) {
        this.players = players;
        this.ladder = ladder;
        this.gameResults = matchGameResults(gameResultNames);
    }

    private GameResults matchGameResults(List<String> gameResultNames) {
        List<GameResult> gameResults = new ArrayList<>();
        for (Player player : players.getPlayers()) {
            String gameResultName = gameResultNames.get(ladder.getGameResultOrderOf(player));
            GameResult gameResult = new GameResult(player, gameResultName);
            gameResults.add(gameResult);
        }
        return new GameResults(gameResults);
    }

    public GameResult getGameResultOf(final String playerName) {
        Player player = players.get(playerName);
        return gameResults.getGameResultOf(player);
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
