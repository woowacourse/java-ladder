package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> lines = new ArrayList<>();

    public Ladder(int lineNumber, int lineHeight) {
        for (int i = 0; i < lineNumber; i++) {
            lines.add(new Line(lineHeight));
        }
    }

    public List<Line> getLines() {
        return lines;
    }

}
