package laddergame.domain.ladder;

import laddergame.domain.point.PointGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Ladder {

    private final List<Line> lines;

    private Ladder(final List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder create(final LineSize lineSize,
                                final LadderHeight height,
                                final PointGenerator pointGenerator) {
        List<Line> lines = Stream.generate(() -> Line.create(lineSize, pointGenerator))
                .limit(height.getHeight())
                .toList();

        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
