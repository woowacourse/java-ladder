package domain;

import java.util.ArrayList;
import java.util.List;
import utils.booleanGenerator.BooleanGenerator;

public class Lines {
    private final List<Line> lines = new ArrayList<>();

    public Lines(int lineSize, int linesHeight, BooleanGenerator booleanGenerator) {
        Height height = new Height(linesHeight);
        for (int i = 0; i < height.getHeight(); i++) {
            Line line = new Line(lineSize, booleanGenerator);
            lines.add(line);
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
