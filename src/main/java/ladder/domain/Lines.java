package ladder.domain;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.Collections.unmodifiableList;

public class Lines {
    private final List<Line> lines;

    public Lines(final int ladderHeight, final int personCount) {
        List<Line> lines = IntStream.rangeClosed(1, ladderHeight)
                .mapToObj(i -> new Line(personCount))
                .toList();
        this.lines = lines;
    }

    public List<Line> getLines() {
        return unmodifiableList(lines);
    }
}
