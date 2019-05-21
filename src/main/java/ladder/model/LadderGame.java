package ladder.model;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    private Players players;
    private Ladder ladder;
    private LadderGameResults ladderGameResults;

    public LadderGame(Players players, Ladder ladder, LadderGameResults ladderGameResults) {
        this.players = players;
        this.ladder = ladder;
        this.ladderGameResults = ladderGameResults;
    }

    public GameResult playGame() {
        Map<Player, LadderGameResult> gameResult = new HashMap<>();
        for (int i = 0; i < this.players.getPlayersNumber(); i++) {
            int startPosition = i;
            Player player = this.players.getPlayerByIndex(startPosition);
            int endPosition = ladder.move(startPosition);

            gameResult.put(this.players.getPlayerByIndex(startPosition), ladderGameResults.getResultByPosition(endPosition));
        }
        return new GameResult(gameResult);
    }
}
