package laddergame.domain.ladder;

import laddergame.domain.Result;
import laddergame.domain.move.FirstStrategy;
import laddergame.domain.move.Trace;
import laddergame.domain.name.Name;
import laddergame.domain.name.Names;
import laddergame.domain.point.PointGenerator;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Ladder {

    private final List<Line> lines;

    public Ladder(final List<Line> lines) {
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

    public Result start(Names names) {
        Map<Name, Trace> map = new HashMap<>();

        for(int i = 0; i < names.getSize(); i++) {
            Trace trace = new Trace(i, new FirstStrategy());
            for(Line line : lines) {
                trace = line.move(trace);
            }
            map.put(names.getNames().get(i),trace);
        }
        return new Result(map);
    }
}
