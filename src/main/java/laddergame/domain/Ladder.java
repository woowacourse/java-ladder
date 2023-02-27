package laddergame.domain;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private final Width width;
    private final Height height;

    private List<Line> lines;

    public Ladder(final Width width, final Height height, final List<Line> lines) {
        this.width = width;
        this.height = height;
        this.lines = lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
