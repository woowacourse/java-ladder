package laddergame.domain.ladder;

import laddergame.domain.result.Trace;
import laddergame.domain.point.PointGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Ladder {

    private final List<Line> lines;

    public Ladder(final List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder create(
            final LineSize lineSize,
            final LadderHeight height,
            final PointGenerator pointGenerator)
    {
        List<Line> lines = Stream.generate(() -> Line.create(lineSize, pointGenerator))
                .limit(height.getHeight())
                .toList();

        return new Ladder(lines);
    }

    public Trace move(final int playerIndex) {
        Trace trace = new Trace(playerIndex);

        for(Line line : lines) {
            trace = line.move(trace);
        }

        return trace;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
