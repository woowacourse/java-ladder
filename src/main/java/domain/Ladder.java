package domain;

import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Row> rows;

    Ladder(Height height, Width width, BridgesGenerator bridgesGenerator) {
        rows = IntStream.range(0, height.getLength())
                .mapToObj(value -> bridgesGenerator.generate(width.getLength() - 1))
                .map(Row::new)
                .toList();
    }

    public List<Row> getRows() {
        return rows;
    }
}
