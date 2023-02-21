package domain;

import domain.ladder.Ladder;
import domain.ladder.PointGenerator;
import domain.players.Players;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;

    public LadderGame(final Players players, final int ladderHeight, final PointGenerator pointGenerator) {
        this.players = players;
        this.ladder = Ladder.of(players.getPlayerSize(), ladderHeight, pointGenerator);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Players getPlayers() {
        return players;
    }

}
