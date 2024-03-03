package ladder.domain.ladder;

import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(lines);
    }

    public int ride(final int position) {
        int value = position;
        for (Line line : lines) {
            value = line.ride(value);
        }
        return value;
    }
}
