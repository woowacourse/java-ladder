package model.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(Height height, Width width) {
        List<Line> lines = new ArrayList<>();
        for (int index = 0; index < height.size(); index++) {
            lines.add(Line.from(width));
        }
        return new Ladder(lines);
    }

    public int size() {
        return lines.size();
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
