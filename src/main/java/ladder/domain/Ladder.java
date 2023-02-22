package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(final List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public int moveToEnd(int startIndex) {
        int resultIndex = 0;
        for (Line line : lines) {
            resultIndex = line.indicateNextIndex(startIndex);
        }
        return resultIndex;
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}
