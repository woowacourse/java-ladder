package laddergame.domain.ladder;

import laddergame.domain.player.Player;

import java.util.List;

public class LadderGame {

    private final Ladder ladder;
    private final List<Player> players;

    public LadderGame(final Ladder ladder, final List<Player> players) {
        this.ladder = ladder;
        this.players = players;
    }

    public static LadderGame of(final Ladder ladder, final List<Player> players) {
        return new LadderGame(ladder, players);
    }

    public List<Player> startGame() {
        final int ladderHeight = ladder.getHeight();
        for (int height = 0; height < ladderHeight; height++) {
            for (final Player player : players) {
                if (player.canMoveLeft() && ladder.canMoveLeft(height, player)) {
                    player.moveLeft();
                }
            }
        }

        return this.players;
    }
}
