package domain;

import java.util.List;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;

    public LadderGame(final Players players, final Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<String> getPlayerNames() {
        return players.getPlayerNames();
    }

}
