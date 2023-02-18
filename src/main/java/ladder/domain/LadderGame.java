package ladder.domain;

import java.util.List;

public class LadderGame {

    private static final int LADDER_WIDTH_SUBTRACT_VALUE = 1;

    private final Players players;
    private final Ladder ladder;

    public LadderGame(final BooleanGenerator booleanGenerator, final Players players, final int height) {
        this.players = players;
        this.ladder = new Ladder(booleanGenerator, height, players.count() - LADDER_WIDTH_SUBTRACT_VALUE);
    }

    public List<String> getPlayers() {
        return players.getNames();
    }

    public List<Line> getLadder() {
        return ladder.getLines();
    }
}
