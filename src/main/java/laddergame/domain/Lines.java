package laddergame.domain;

import laddergame.util.LinesGenerator;

import java.util.Collections;
import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(final LinesGenerator linesGenerator,
                 final int width) {
        this.lines = linesGenerator.generate(width);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
