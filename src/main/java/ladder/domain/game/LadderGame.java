package ladder.domain.game;

import ladder.domain.Direction;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Rung;
import ladder.domain.player.Player;

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

    public PlayResult play() {
        final int playerCount = players.count();
        final int lineCount = ladder.countLine();

        for (int index = 0; index < playerCount; index++) {
            final Player player = players.getPlayer(index);

            climbLadder(player, lineCount);
        }

        return new PlayResult(players.getPlayers(), prizes.getPrizes());
    }

    private void climbLadder(final Player player, final int lineCount) {
        for (int lineIndex = 0; lineIndex < lineCount; lineIndex++) {
            final List<Rung> rungs = ladder.getRungsOf(lineIndex);

            final Direction direction = player.findMovableDirection(rungs);
            player.moveTo(direction);
        }
    }
}
