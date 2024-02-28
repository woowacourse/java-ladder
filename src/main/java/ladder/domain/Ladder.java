package ladder.domain;

import java.util.Arrays;

import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(Line... lines) {
        this(Arrays.asList(lines));
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public int execute(int index) {
        for (Line line : lines) {
            index = determineNextIndex(index, line);
        }
        return index;
    }

    private int determineNextIndex(int currentIndex, Line line) {
        int previousIndex = currentIndex - 1;
        if (line.isPointUsed(currentIndex)) {
            return currentIndex + 1;
        }
        if (previousIndex >= 0 && line.isPointUsed(previousIndex)) {
            return currentIndex - 1;
        }
        return currentIndex;
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(lines);
    }
}
