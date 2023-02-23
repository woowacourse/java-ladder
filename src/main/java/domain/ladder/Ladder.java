package domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import util.BooleanGenerator;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder valueOf(LadderSize ladderSize, BooleanGenerator booleanGenerator) {
        List<Line> lines = generate(ladderSize, booleanGenerator);
        return new Ladder(lines);
    }

    private static List<Line> generate(LadderSize ladderSize, BooleanGenerator booleanGenerator) {
        return IntStream.range(0, ladderSize.getHeight())
            .mapToObj((count) -> Line.valueOf(ladderSize.getLineWeight(), booleanGenerator))
            .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
