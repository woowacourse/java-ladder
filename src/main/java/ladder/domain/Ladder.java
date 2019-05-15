package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> lines = new ArrayList<>();

    public Ladder(int lineNumber, int countPerson) {
        for (int i = 0; i < lineNumber; i++) {
            lines.add(new Line(countPerson));
        }
    }

    public List<Line> getLines() {
        return lines;
    }

}
