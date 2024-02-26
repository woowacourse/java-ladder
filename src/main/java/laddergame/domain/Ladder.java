package laddergame.domain;

import laddergame.domain.strategy.LinesBuilder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Lines> lines;

    public Ladder(final LinesBuilder linesBuilder,
                  final Players players,
                  final Height height) {
        this.lines = IntStream.range(0, height.getHeight())
                .mapToObj(i -> new Lines(linesBuilder, players.getPlayersCount() - 1))
                .collect(Collectors.toList());
    }

    public List<Lines> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
