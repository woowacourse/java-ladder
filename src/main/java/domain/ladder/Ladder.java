package domain.ladder;

import domain.strategy.BridgeMakingStrategy;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.Collections.unmodifiableList;


public class Ladder {
    private static final int WIDTH_MIN = 2, WIDTH_MAX = 10;
    private static final int HEIGHT_MIN = 1, HEIGHT_MAX = 10;
    private final List<Row> rows;

    public Ladder(final int width, final int height, final BridgeMakingStrategy strategy) {
        validateSize(width, height);
        this.rows = makeLadder(width, height, strategy);
    }

    private void validateSize(final int width, final int height) {
        if (WIDTH_MIN > width || width > WIDTH_MAX) {
            throw new IllegalArgumentException("잘못된 크기가 입력됐습니다. ");
        }
        if (HEIGHT_MIN > height || height > HEIGHT_MAX) {
            throw new IllegalArgumentException("잘못된 크기가 입력됐습니다. ");
        }
    }

    private List<Row> makeLadder(final int width, final int height, final BridgeMakingStrategy strategy) {
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
