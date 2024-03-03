package domain;

import domain.generator.BridgeGenerator;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final Map<Level, Line> lines;

    public Ladder(Players players, Height height, BridgeGenerator bridgeGenerator) {
        this.lines = createLines(players, height, bridgeGenerator);
    }

    private Map<Level, Line> createLines(Players players, Height height, BridgeGenerator bridgeGenerator) {
        return IntStream.range(0, height.getHeight())
                .boxed()
                .collect(Collectors.toMap(
                        Level::new,
                        index -> new Line(players.getTotalPlayerSize(), bridgeGenerator),
                        (line, line2) -> line2,
                        LinkedHashMap::new
                ));
    }

    public Result calculate(Players players, Prizes prizes) {
        return players.getPlayers().stream()
                .collect(Collectors.collectingAndThen(Collectors.toMap(
                                Function.identity(),
                                player -> prizes.getPrizeIndexOf(calculatePlayerPosition(players.getPositionOf(player)))),
                        Result::new));
    }

    private int calculatePlayerPosition(int position) {
        for (Line line : lines.values()) {
            position = line.calculatePosition(position);
        }
        return position;
    }

    public Map<Level, Line> getLines() {
        return Collections.unmodifiableMap(lines);
    }
}
