package laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import laddergame.domain.strategy.BuildStrategy;
import laddergame.domain.strategy.PointBuildStrategy;

public class Ladder {
    private final List<Line> lines;
    private final BuildStrategy pointBuildStrategy = new PointBuildStrategy();

    public Ladder(final int playerCount, final Height height) {
        this.lines = IntStream.range(0, height.getHeight())
                .mapToObj(i -> new Line(playerCount, pointBuildStrategy))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }
}
