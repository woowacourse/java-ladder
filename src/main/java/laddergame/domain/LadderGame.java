package laddergame.domain;

import laddergame.util.RandomPointGenerator;

import java.util.List;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;

    public LadderGame(Players players, int ladderHeight) {
        this.players = players;

        LadderMaker ladderMaker = new LadderMaker(new RandomPointGenerator());
        this.ladder = ladderMaker.make(players.size(), new LadderHeight(ladderHeight));
    }

    public List<String> getPlayerNames() {
        return players.getPlayerNames();
    }

    public List<Line> getLadderMap() {
        return ladder.getLadder();
    }
}
