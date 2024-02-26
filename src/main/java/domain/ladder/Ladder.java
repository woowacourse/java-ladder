package domain.ladder;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.Collections.unmodifiableList;


public class Ladder {
    private final BridgeMakingStrategy strategy;
    private final List<Row> rows;

    public Ladder(final int width, final int height, BridgeMakingStrategy strategy) {
        this.strategy = strategy;
        this.rows = generateLadder(width, height);
    }

    private List<Row> generateLadder(final int width, final int height) {
        return IntStream.range(0, height)
                .mapToObj(ignore -> new Row(width, strategy))
                .toList();
    }

    public List<Row> getRows() {
        return unmodifiableList(this.rows);
    }

    public int getWidth() {
        return this.rows.get(0).getWidth();
    }
}
