package domain.ladder;

import java.util.List;

public class Ladder {
    private final List<Line> lines;
    private final int height;

    public Ladder(List<Line> lines, int height) {
        this.lines = lines;
        this.height = height;
    }

    public List<Line> getLines() {
        return lines;
    }
}
