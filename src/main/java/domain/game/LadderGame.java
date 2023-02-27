package domain.game;

import domain.ladder.Ladder;
import domain.player.Player;
import domain.player.Players;
import domain.result.Prizes;
import domain.result.Result;

public class LadderGame {
    private static final String GAME_NOT_PLAYED_MESSAGE = "게임이 아직 플레이 되지 않았습니다.";
    private final Ladder ladder;
    private final Players players;
    private final Prizes prizes;

    private final State gameState;

    public LadderGame(Ladder ladder, Players players, Prizes prizes) {
        this.gameState = new State();

        this.ladder = ladder;
        this.players = players;
        this.prizes = prizes;
    }

    public void play() {
        for (Player player : players.getPlayers()) {
            ladder.ride(player);
        }
        gameState.flipState();
    }

    public Result getResult() {
        validateGamePlayedState();
        return new Result(players, prizes);
    }

    private void validateGamePlayedState() {
        if (!this.gameState.isPlayed()) {
            throw new IllegalStateException(GAME_NOT_PLAYED_MESSAGE);
        }
    }
}
