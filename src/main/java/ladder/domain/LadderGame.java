package ladder.domain;

import java.util.List;

public class LadderGame {

    private static final int SUBTRACT_VALUE_OF_LADDER_WIDTH = 1;

    private final Players players;
    private final Ladder ladder;

    public LadderGame(final BooleanGenerator booleanGenerator, final List<String> names, final int height) {
        this.players = new Players(names);
        this.ladder = new Ladder(booleanGenerator, height, names.size() - SUBTRACT_VALUE_OF_LADDER_WIDTH);
    }

    public List<String> getPlayers() {
        return players.getNames();
    }

    public List<Line> getLadder() {
        return ladder.getLines();
    }
}
