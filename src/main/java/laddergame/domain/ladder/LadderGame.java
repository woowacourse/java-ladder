package laddergame.domain.ladder;

import laddergame.domain.Players;
import laddergame.domain.Prizes;
import laddergame.domain.Result;
import laddergame.domain.player.Player;

import java.util.List;

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

    public Players startGame() {
        final int ladderHeight = ladder.getHeight();
        for (int height = 0; height < ladderHeight; height++) {
            movePlayers(height);
        }

        return this.players;
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
        return player.canMoveLeft() && ladder.canMoveLeft(height, player);
    }

    private boolean canMoveRight(final int height, final Player player) {
        return ladder.canMoveRight(height, player);
    }

    public Result findIndividualResult(final String name) {
        final Player player = players.findPlayerByName(name);
        final Players players = new Players(List.of(player));

        final List<String> prizeName = List.of(this.prizes.getPrizeName(player.getPosition()));
        final Prizes prizes = new Prizes(prizeName, players.getPlayerSize());
        return new Result(players, prizes);
    }
}
