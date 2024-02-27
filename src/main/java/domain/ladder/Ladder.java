package domain.ladder;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.Collections.unmodifiableList;


public class Ladder {
    private final List<Row> rows;

    public Ladder(
            final int width,
            final int height,
            final BridgeMakingStrategy strategy
    ) {
        this.rows = generateLadder(width, height, strategy);
    }

    // TODO: LADDER를 만드는 역할을 누구까지 알아야 하는게 맞나

    private List<Row> generateLadder(
            final int width,
            final int height,
            final BridgeMakingStrategy strategy
    ) {
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
