package domain;

import java.util.List;
import java.util.stream.IntStream;

class Ladder {
    private final List<Row> rows;

    Ladder(Height height, Width width, RowInfoGenerator rowInfoGenerator) {
        rows = IntStream.range(0, height.getLength())
                .mapToObj(value -> rowInfoGenerator.generate(width.getLength() - 1))
                .map(Row::new)
                .toList();
    }

    List<Row> getRows() {
        return rows;
    }
}
