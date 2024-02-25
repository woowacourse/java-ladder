package domain;

import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Row> rows;

    Ladder(Height height, Width width, RowGenerator rowGenerator) {
        rows = IntStream.range(0, height.getLength())
                .mapToObj(value -> rowGenerator.generate(width.getLength() - 1))
                .toList();
    }

    public List<Row> getRows() {
        return rows;
    }
}
