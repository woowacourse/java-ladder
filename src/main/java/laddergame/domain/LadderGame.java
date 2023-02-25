package laddergame.domain;

import java.util.List;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;
    private final Prizes prizes;

    public LadderGame(Players players, Ladder ladder, Prizes prizes) {
        this.players = players;
        this.ladder = ladder;
        this.prizes = prizes;
    }

    public List<String> getPlayerNames() {
        return players.getPlayerNames();
    }

    public List<Line> getLadderMap() {
        return ladder.getLadder();
    }

    public List<String> getPrizeNames() {
        return prizes.getPrizes();
    }
}
