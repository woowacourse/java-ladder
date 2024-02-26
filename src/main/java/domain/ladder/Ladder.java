package domain.ladder;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.Collections.unmodifiableList;


public class Ladder {
    private static final Random random = new Random();
    private final List<Line> lines;

    public Ladder(final int width, final int height) {
        this.lines = generateLadder(width, height);
    }

    private List<Line> generateLadder(final int width, final int height) {
        return IntStream.range(0, height)
                .mapToObj(ignore -> new Line(width, () -> Bridge.getOne(random.nextBoolean())))
                .toList();
    }

    public List<Line> getLines() {
        return unmodifiableList(this.lines);
    }

    public int getWidth() {
        return this.lines.get(0).getWidth();
    }
}
