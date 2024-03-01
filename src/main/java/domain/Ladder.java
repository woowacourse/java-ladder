package domain;

import domain.generator.BridgeGenerator;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final Map<Integer, Line> lines;

    public Ladder(Players players, Height height, BridgeGenerator bridgeGenerator) {
        this.lines = IntStream.range(0, height.getHeight())
                .boxed()
                .collect(Collectors.toMap(index -> index,
                        index -> new Line(players.getTotalPlayerSize(), bridgeGenerator)));
    }

    public Map<String, Integer> calculate(Players players) {
        List<String> names = players.getNames();
        return calculateTotalPosition(players, names);
    }

    private Map<String, Integer> calculateTotalPosition(Players players, List<String> names) {
        return players.getNames().stream()
                .collect(Collectors.toMap(Function.identity(),
                        name -> calculatePlayerIndexOf(names.indexOf(name))));
    }

    private int calculatePlayerIndexOf(int playerIndex) {
        for (Line line : lines.values()) {
            playerIndex = line.calculatePosition(playerIndex);
        }
        return playerIndex;
    }

    public Map<Integer, Line> getLines() {
        return Collections.unmodifiableMap(lines);
    }
}
