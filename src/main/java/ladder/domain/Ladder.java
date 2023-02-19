package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;
    private final Height height;

    public Ladder(int height) {
        this.height = new Height(height);
        this.lines = new ArrayList<>();
    }

    public void assignLines(LineStrategy lineStrategy, int sectionCount) {
        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(new Line(lineStrategy, sectionCount));
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
