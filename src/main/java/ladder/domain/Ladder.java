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

    public Index climb(Index index) {
        for (Line line : lines) {
            index = line.move(index);
        }
        return index;
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(lines);
    }
}
