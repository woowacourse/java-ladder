package domain;

import domain.generator.BridgeGenerator;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final Map<Level, Line> lines;
    private final Result result;

    public Ladder(Players players, Height height, BridgeGenerator bridgeGenerator) {
        this.lines = createLines(players, height, bridgeGenerator);
        this.result = ResultCalculator.calculate(players, lines);
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

    public Map<Level, Line> getLines() {
        return Collections.unmodifiableMap(lines);
    }

    public Result getResult() {
        return result;
    }
}
