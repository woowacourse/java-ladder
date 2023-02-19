package domain;

import java.util.List;

public class Ladder {
    private final List<Line> lines;
    private final Height height;

    public Ladder(List<Line> lines, Height height) {
        this.lines = lines;
        this.height = height;
    }

    public List<Line> getLines() {
        return lines;
    }
}
