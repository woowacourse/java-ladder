package ladder.domain;

import java.util.List;

public class LadderGame {

    private static final int SUBTRACT_LADDER_WIDTH_VALUE = 1;

    private final Players players;
    private final Ladder ladder;

    private LadderGame(final Players players, final Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public static LadderGame initialize(
            final Players players,
            final BooleanGenerator booleanGenerator,
            final int height
    ) {
        final Ladder ladder = Ladder.generate(booleanGenerator, height, players.count() - SUBTRACT_LADDER_WIDTH_VALUE);
        return new LadderGame(players, ladder);
    }

    public List<String> getPlayers() {
        return players.getNames();
    }

    public List<Line> getLadder() {
        return ladder.getLines();
    }
}
