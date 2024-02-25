package ladder.domain;

import static java.util.Collections.unmodifiableList;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Lines {
    private final List<Line> lines;

    private Lines(final List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(Supplier<Boolean> generator, final int ladderHeight, final int userCount) {
        return new Lines(createLines(generator, ladderHeight, userCount));
    }

    private static List<Line> createLines(Supplier<Boolean> generator, final int ladderHeight, final int userCount) {
        return IntStream.rangeClosed(1, ladderHeight)
                .mapToObj(i -> new Line(generator, userCount))
                .toList();
    }

    public List<Integer> findStepPositions() {
        return lines.stream()
                .flatMap(line -> line.findStepPosition().stream())
                .toList();
    }

    public List<Line> getLines() {
        return unmodifiableList(lines);
    }
}
