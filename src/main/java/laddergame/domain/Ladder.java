package laddergame.domain;

import laddergame.domain.strategy.LineBuildStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder buildOf(final LineBuildStrategy lineBuildStrategy,
                                 final Players players,
                                 final Height height)
    {
        List<Line> lines = IntStream.range(0, height.getHeight())
                    .mapToObj(i -> Line.buildOf(lineBuildStrategy, players.getPlayersCount() - 1))
                    .collect(Collectors.toList());
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return lines;
    }
}
