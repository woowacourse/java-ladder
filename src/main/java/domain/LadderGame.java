package domain;

import domain.ladder.Ladder;
import domain.players.Players;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;

    public LadderGame(final Players players, final int ladderHeight) {
        this.players = players;
        this.ladder = Ladder.of(players.getPlayerSize(), ladderHeight);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Players getPlayers() {
        return players;
    }

}
