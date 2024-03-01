package domain;

import domain.generator.BridgeGenerator;
import java.util.Collections;
import java.util.Map;
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

    public Map<Integer, Line> getLines() {
        return Collections.unmodifiableMap(lines);
    }
}
