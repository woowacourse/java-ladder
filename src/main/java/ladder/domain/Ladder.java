package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final String[] names;
    private final List<Line> lines;

    public Ladder(String[] names, int height) {
        this.names = names;
        this.lines = new ArrayList<>();
        addLines(names, height);
    }

    private void addLines(String[] names, int height) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(names.length));
        }
    }

    public String[] getNames() {
        return names;
    }

    public List<Line> getLines() {
        return lines;
    }
}
