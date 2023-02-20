package domain;

import java.util.Map;

public class Game {

    private final Ladder ladder;
    private final Players players;
    private final LadderResults ladderResults;
    private final Calculator calculator;

    public Game(final Players players, final Ladder ladder, final LadderResults ladderResults) {
        this.ladder = ladder;
        this.players = players;
        this.ladderResults = ladderResults;
        this.calculator = new Calculator(players, ladder, ladderResults);
    }

    public Map<Player, LadderResult> findGameResults() {
        return this.calculator.getPlayerWithResult();
    }

    public String findPlayerResult(final String playerName) {
        Player player = players.findPlayerByName(playerName);
        return calculator.findPlayerResult(player);
    }
}
