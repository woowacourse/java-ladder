package ladder.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
    private static final int SUBTRACT_LADDER_WIDTH_VALUE = 1;

    private final Players players;
    private final Ladder ladder;
    private final Items items;

    private LadderGame(final Players players, final Ladder ladder, final Items items) {
        this.players = players;
        this.ladder = ladder;
        this.items = items;
    }

    public static LadderGame initialize(
            final Players players,
            final BooleanGenerator booleanGenerator,
            final int height,
            final Items items
    ) {
        final Ladder ladder = Ladder.generate(booleanGenerator, height, players.count() - SUBTRACT_LADDER_WIDTH_VALUE);
        return new LadderGame(players, ladder, items);
    }

    public LadderGameResult play() {
        final Map<Player, Item> result = new LinkedHashMap<>();
        for (Position position : Position.range(players.count())) {
            final Position resultPosition = ladder.play(position);
            result.put(players.get(position), items.get(resultPosition));
        }
        return new LadderGameResult(result);
    }

    public List<String> getPlayers() {
        return players.getNames();
    }

    public List<Line> getLadder() {
        return ladder.getLines();
    }
}
