package ladder.domain;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.Collections.unmodifiableList;

public class Lines {
    private final List<Line> lines;

    private Lines(final List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(final int ladderHeight, final int personCount) {
        return new Lines(createLines(ladderHeight, personCount));
    }

    private static List<Line> createLines(final int ladderHeight, final int personCount) {
        return IntStream.rangeClosed(1, ladderHeight)
                .mapToObj(i -> new Line(personCount))
                .toList();
    }

    public List<Line> getLines() {
        return unmodifiableList(lines);
    }
}
