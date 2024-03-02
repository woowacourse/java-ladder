package domain.ladder;

import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Row> rows;

    private final Width width;

    public Ladder(Height height, Width width, RowGenerator rowGenerator) {
        rows = IntStream.range(0, height.getLength())
                .mapToObj(value -> rowGenerator.generate(width.getLength() - 1))
                .toList();
        this.width = width;
    }

    public List<Row> getRows() {
        return rows;
    }

    public LadderPositions goDown() {
        LadderPositions ladderPositions = new LadderPositions(width.getLength());
        for (Row row : rows) {
            ladderPositions = ladderPositions.calculatePosition(row);
        }
        return ladderPositions;
    }
}
