package model.ladder;

import java.util.Collections;
import java.util.List;
import model.line.Line;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = Collections.unmodifiableList(lines);
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getWidth() {
        return lines.get(0).getSize();
    }
}
