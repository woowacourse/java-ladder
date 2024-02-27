package domain.ladder;

import java.util.List;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.IntStream.range;


public class Ladder {
    private final List<Row> rows;

    public Ladder(
            final int width,
            final int height,
            final BridgeMakingStrategy strategy
    ) {
        this.rows = makeLadder(width, height, strategy);
    }

    private List<Row> makeLadder(
            final int width,
            final int height,
            final BridgeMakingStrategy strategy
    ) {
        return range(0, height)
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
