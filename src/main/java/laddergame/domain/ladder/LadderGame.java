package laddergame.domain.ladder;

import laddergame.domain.player.Player;
import laddergame.domain.player.Players;
import laddergame.domain.prize.Prizes;
import laddergame.domain.prize.Results;

public class LadderGame {

    private final Ladder ladder;
    private final Players players;
    private final Prizes prizes;

    public LadderGame(final Ladder ladder, final Players players, final Prizes prizes) {
        this.ladder = ladder;
        this.players = players;
        this.prizes = prizes;
    }

    public static LadderGame of(final Ladder ladder, final Players players, final Prizes prizes) {
        return new LadderGame(ladder, players, prizes);
    }

    public void startGame() {
        final int ladderHeight = ladder.getHeight();
        for (int height = 0; height < ladderHeight; height++) {
            movePlayers(height);
        }
    }

    private void movePlayers(final int height) {
        for (final Player player : players.getPlayers()) {
            movePlayer(height, player);
        }
    }

    private void movePlayer(final int height, final Player player) {
        if (canMoveLeft(height, player)) {
            player.moveLeft();
            return;
        }

        if (canMoveRight(height, player)) {
            player.moveRight();
        }
    }

    private boolean canMoveLeft(final int height, final Player player) {
        return ladder.canMoveLeft(height, player);
    }

    private boolean canMoveRight(final int height, final Player player) {
        return ladder.canMoveRight(height, player);
    }

    public Results createResults() {
        return new Results(players, prizes);
    }
}
