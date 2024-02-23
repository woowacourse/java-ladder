package domain;

import java.util.List;
import java.util.stream.IntStream;

class Ladder {
    private final List<Row> rows;

    Ladder(Height height, Width width, BridgeGenerator bridgeGenerator) {
        rows = IntStream.range(0, height.getLength())
                .mapToObj(value -> bridgeGenerator.generate(width.getLength() - 1))
                .map(Row::new)
                .toList();
    }

    List<Row> getRows() {
        return rows;
    }
}
