package laddergame.domain;

import laddergame.util.RandomPointGenerator;

import java.util.List;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;

    public LadderGame(Players players, int ladderHeight) {
        this.players = players;
        this.ladder = new Ladder(players.size(), ladderHeight, new RandomPointGenerator());
    }

    public List<String> getPlayerNames() {
        return players.getPlayerNames();
    }

    public List<Line> getLadderMap() {
        return ladder.getLadder();
    }
}
