package domain;

import java.util.List;
import java.util.stream.IntStream;

class Ladder {
    private final List<Row> rows;
    
    Ladder(int rawHeight, int rawWidth, BridgeGenerator bridgeGenerator) {
        Height height = new Height(rawHeight);
        Width width = new Width(rawWidth);
        rows = IntStream.range(0, height.getLength())
                .mapToObj(value -> bridgeGenerator.generate(width.getLength() - 1))
                .map(Row::new)
                .toList();
    }

    List<Row> getRows() {
        return rows;
    }
}
