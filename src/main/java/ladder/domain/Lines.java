package ladder.domain;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import ladder.dto.LineResult;

public class Lines {
    private final List<Line> lines;

    private Lines(final List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(Supplier<Boolean> generator, final int ladderHeight, final int personCount) {
        return new Lines(createLines(generator, ladderHeight, personCount));
    }

    private static List<Line> createLines(Supplier<Boolean> generator, final int ladderHeight, final int personCount) {
        return IntStream.rangeClosed(1, ladderHeight)
                .mapToObj(i -> new Line(generator, personCount))
                .toList();
    }

    public List<LineResult> getLineResults() {
        return lines.stream()
                .map(Line::getLineResult)
                .toList();
    }
}
