package ladder;

import ladder.domain.Ladder;
import ladder.domain.Player;
import ladder.domain.Players;

public class LadderGame {
    private final Ladder ladder;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public void movePlayers(Players players) {
        for (Player player : players.getPlayers()) {
            ladder.goDownLadder(player);
        }
    }
}
