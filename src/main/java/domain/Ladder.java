package domain;

import java.util.ArrayList;
import java.util.List;
import util.BooleanGenerator;

public class Ladder {
    private final List<Line> lines;

    public Ladder(Height height, int personCount) {
        this.lines = new ArrayList<>();
        for (int index = 0; index < height.getHeight(); index++) {
            lines.add(new Line(personCount));
        }
    }

    public void generateLadder(BooleanGenerator booleanGenerator) {
        for (Line line : lines) {
            line.generate(booleanGenerator);
        }
    }

    public int calculateTotalHeight() {
        return lines.size();
    }

    public List<Line> getLines() {
        return lines;
    }
}
