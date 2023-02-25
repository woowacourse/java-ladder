package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(int countOfLine, int countOfBar) {
        lines = new ArrayList<>();
        generateLines(countOfLine, countOfBar);
    }

    private void generateLines(int countOfLine, int countOfBar) {
        for (int i = 0; i < countOfLine; i++) {
            lines.add(new Line(countOfBar));
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
