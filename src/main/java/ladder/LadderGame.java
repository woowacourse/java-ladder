package ladder;

import ladder.domain.gamecomponent.Ladder;
import ladder.domain.gamecomponent.Player;
import ladder.domain.gamecomponent.Players;

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
