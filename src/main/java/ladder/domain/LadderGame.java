package ladder.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ladder.util.BooleanGenerator;

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
            final Height height,
            final Items items
    ) {
        final int ladderWidth = players.count() - SUBTRACT_LADDER_WIDTH_VALUE;
        final Ladder ladder = Ladder.generate(booleanGenerator, height.getValue(), ladderWidth);
        return new LadderGame(players, ladder, items);
    }

    public LadderGameResult play() {
        final Map<Player, Position> playResult = players.play(ladder);

        final Map<Player, Item> result = new LinkedHashMap<>();
        for (Player player : playResult.keySet()) {
            result.put(player, toItem(playResult.get(player)));
        }
        return new LadderGameResult(result);
    }

    private Item toItem(final Position position) {
        return items.findByPosition(position);
    }

    public List<String> getPlayers() {
        return players.getNames();
    }

    public List<Line> getLadder() {
        return ladder.getLines();
    }

    public List<String> getItems() {
        return items.getNames();
    }
}
