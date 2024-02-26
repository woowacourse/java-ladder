package laddergame.domain;

import laddergame.domain.strategy.LinesBuilder;

import java.util.Collections;
import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(final LinesBuilder linesBuilder,
                 final int width) {
        this.lines = linesBuilder.build(width);
    }

    public List<Line> getZones() {
        return Collections.unmodifiableList(lines);
    }
}
