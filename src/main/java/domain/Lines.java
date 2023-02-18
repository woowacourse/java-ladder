package domain;

import java.util.ArrayList;
import java.util.List;
import utils.booleanGenerator.BooleanGenerator;
import utils.booleanGenerator.RandomBooleanGenerator;

public class Lines {
    private final List<Line> lines = new ArrayList<>();

    public Lines(int lineNumber, int linesHeight, BooleanGenerator booleanGenerator) {
        Height height = new Height(linesHeight);
        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(new Line(lineNumber, booleanGenerator));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
