package ladder.domain.game;

import ladder.domain.ladder.Ladder;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;

    public LadderGame(final Ladder ladder, final Players players) {
        this.ladder = ladder;
        this.players = players;
    }

    public PlayResult play() {
        players.climb(ladder);
        return new PlayResult(players.getPlayers());
    }
}
