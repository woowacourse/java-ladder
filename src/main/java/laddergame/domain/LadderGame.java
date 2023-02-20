package laddergame.domain;

import laddergame.util.RandomPointGenerator;

import java.util.List;

public class LadderGame {

    private Players players;
    private Ladder ladder;

    public LadderGame(Players players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public List<String> getPlayerNames() {
        return players.getPlayerNames();
    }

    public List<Line> getLadderMap() {
        return ladder.getLadder();
    }
}
