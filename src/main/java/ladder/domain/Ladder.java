package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public int moveToResult(int position) {
        for (Line line : lines) {
            position = line.move(position);
        }
        return position;
    }

    public int getLadderWidth() {
        return lines.get(0).getSize() + 1;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
