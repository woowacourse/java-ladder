package domain;

import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Bridges> ladder;

    Ladder(Height height, Width width, BridgesGenerator bridgesGenerator) {
        ladder = IntStream.range(0, height.getLength())
                .mapToObj(value -> bridgesGenerator.generate(width.getLength() - 1))
                .toList();
    }

    public List<Bridges> getLadder() {
        return ladder;
    }
}
