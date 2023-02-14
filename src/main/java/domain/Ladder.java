package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private List<Line> lines = new ArrayList<>();

    public void add(Line line) {
        lines.add(line);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
