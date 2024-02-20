package ladder.domain;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static java.util.Collections.unmodifiableList;

public class Lines {
    private final List<Line> lines;

    private Lines(final List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(final Supplier<Boolean> generator, final int ladderHeight, final int personCount) {
        return new Lines(createLines(generator, ladderHeight, personCount));
    }

    private static List<Line> createLines(final Supplier<Boolean> generator, final int ladderHeight, final int personCount) {
        return IntStream.rangeClosed(1, ladderHeight)
                .mapToObj(i -> new Line(generator, personCount))
                .toList();
    }

    public List<Line> getLines() {
        return unmodifiableList(lines);
    }
}
