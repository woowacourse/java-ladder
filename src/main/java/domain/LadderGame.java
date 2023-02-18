package domain;

import factory.LadderFactory;

import java.util.List;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;

    public LadderGame(final Players players, final int ladderHeight) {
        this.players = players;
        this.ladder = LadderFactory.of(players.getPlayerSize(), ladderHeight);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<String> getPlayerNames() {
        return players.getPlayerNames();
    }

}
