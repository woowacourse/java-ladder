package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int CountOfPerson, int height) {
        this.lines = new ArrayList<>();
        addLines(CountOfPerson, height);
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    private void addLines(int CountOfPerson, int height) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(CountOfPerson));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
