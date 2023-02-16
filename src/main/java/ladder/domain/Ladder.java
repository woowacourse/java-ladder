package ladder.domain;

import ladder.utils.LineStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;
    private final Height maxHeight;

    public Ladder(int height) {
        this.maxHeight = new Height(height);
        this.lines = new ArrayList<>();
    }

    public void assignLines(LineStrategy lineStrategy, int partCount) {
        for (int i = 0; i < maxHeight.getHeight(); i++) {
            lines.add(new Line(lineStrategy, partCount));
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
