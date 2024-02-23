package domain;

import java.util.List;
import java.util.stream.IntStream;


public class Ladder {
    private final List<Line> lines;

    public Ladder(final int width, final int height) {
        lines = generateLadder(width, height);
    }

    public List<Line> generateLadder(final int width, final int height) {
        return IntStream.range(0, height)
                .mapToObj(ignore -> new Line(width))
                .toList();
    }

    public List<Line> getLines() {
        return lines;
    }
}
