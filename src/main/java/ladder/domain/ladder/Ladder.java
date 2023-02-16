package ladder.domain.ladder;

import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(final List<Line> lines) {
        this.lines = List.copyOf(lines);
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}
