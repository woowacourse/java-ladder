package ladder.domain;

import java.util.List;

public class Ladder {
    private final List<Line> lines;
    private int index = 0;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public Line getNextLine() {
        return lines.get(index++);
    }

    public boolean hasNextLine() {
        return index < lines.size();
    }
}
