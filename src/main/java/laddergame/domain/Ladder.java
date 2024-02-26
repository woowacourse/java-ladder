package laddergame.domain;

import laddergame.domain.strategy.LineBuildStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(final LineBuildStrategy lineBuildStrategy,
                  final Players players,
                  final Height height) {
        this.lines = IntStream.range(0, height.getHeight())
                .mapToObj(i -> new Line(lineBuildStrategy, players.getPlayersCount() - 1))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
