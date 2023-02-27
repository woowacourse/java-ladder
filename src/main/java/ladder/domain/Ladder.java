package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ladder.utils.BarGenerator;
import ladder.utils.BooleanGenerator;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int countOfLine, int countOfBar) {
        this(countOfLine, countOfBar, new BarGenerator());
    }

    public Ladder(int countOfLine, int countOfBar, BooleanGenerator booleanGenerator) {
        lines = new ArrayList<>();
        generateLines(countOfLine, countOfBar, booleanGenerator);
    }

    private void generateLines(int countOfLine, int countOfBar, BooleanGenerator booleanGenerator) {
        for (int i = 0; i < countOfLine; i++) {
            lines.add(new Line(countOfBar, booleanGenerator));
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public void move(Location location) {
        this.lines.forEach(line -> line.move(location));
    }
}
