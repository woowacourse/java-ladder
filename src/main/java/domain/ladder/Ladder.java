package domain.ladder;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.Collections.unmodifiableList;


public class Ladder {
    private final BridgeMakingStrategy strategy;
    private final List<Line> lines;

    public Ladder(final int width, final int height, BridgeMakingStrategy strategy) {
        this.strategy = strategy;
        this.lines = generateLadder(width, height);
    }

    private List<Line> generateLadder(final int width, final int height) {
        return IntStream.range(0, height)
                .mapToObj(ignore -> new Line(width, strategy))
                .toList();
    }

    public List<Line> getLines() {
        return unmodifiableList(this.lines);
    }

    public int getWidth() {
        return this.lines.get(0).getWidth();
    }
}
