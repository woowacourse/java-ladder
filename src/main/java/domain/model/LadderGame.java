package domain.model;

import domain.vo.Height;
import domain.vo.Width;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {

    private final BooleanGenerator booleanGenerator;

    public LadderGame(BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
    }

    public Ladder makeLadder(final Height height, final Width width) {
        final List<Layer> layers = IntStream.range(0, height.getValue())
            .mapToObj(index -> new Layer(new ArrayList<>(), booleanGenerator))
            .collect(Collectors.toList());
        final Ladder ladder = new Ladder(height, width, layers);
        ladder.makeLineInLayers();
        return ladder;
    }

    public Map<Player, Result> makeResultBoard(final Ladder ladder, final Players players, final Results results) {
        final Map<Player, Result> resultBoard = new HashMap<>();
        IntStream.range(0, players.size()).forEach(index -> {
            final int resultIndex = ladder.ride(new Location(index));
            final Result result = results.getResults().get(resultIndex);
            resultBoard.put(players.getPlayers().get(index), result);
        });
        return resultBoard;
    }
}
