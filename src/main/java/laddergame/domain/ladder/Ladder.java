package laddergame.domain.ladder;

import laddergame.domain.Result;
import laddergame.domain.move.LeftStrategy;
import laddergame.domain.move.Trace;
import laddergame.domain.player.Player;
import laddergame.domain.player.Players;
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

    public Result start(Players players) {
        Map<Player, Trace> map = new HashMap<>();

        for (int i = 0; i < players.getSize(); i++) {
            Trace trace = moveLines(i);
            map.put(players.getName(i), trace);
        }
        return new Result(map);
    }

    private Trace moveLines(int position) {
        Trace trace = Trace.init(position, new LeftStrategy());

        for(Line line : lines) {
            trace = line.move(trace);
        }

        return trace;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
