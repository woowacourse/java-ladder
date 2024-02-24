package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder createByStrategy(BridgeGenerator bridgeGenerator, int height, int personCount) {
        final List<Line> lines = Stream.generate(() -> Line.createByStrategy(bridgeGenerator, personCount))
                .limit(height)
                .toList();

        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
