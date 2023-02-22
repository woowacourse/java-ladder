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
}
