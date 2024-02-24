package ladder.domain;

import ladder.dto.LineResult;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.unmodifiableList;

public class Lines {
    private final List<Line> lines;

    private Lines(final List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(final Supplier<Boolean> generator, final int ladderHeight, final int personCount) {
        return IntStream.rangeClosed(1, ladderHeight)
                .mapToObj(i -> new Line(generator, personCount))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lines::new));
    }

    public List<Line> getLines() {
        return unmodifiableList(lines);
    }

    public List<LineResult> getLineResults() {
        return lines.stream()
                .map(LineResult::of)
                .toList();
    }
}
