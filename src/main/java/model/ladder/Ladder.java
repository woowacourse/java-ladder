package model.ladder;

import java.util.List;
import model.line.Line;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = List.copyOf(lines);
    }

    public List<Line> getLines() {
        return lines;
    }

    public int width() {
        return lines.get(0).size();
    }
}
