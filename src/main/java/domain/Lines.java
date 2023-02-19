package domain;

import java.util.ArrayList;
import java.util.List;
import domain.booleangenerator.BooleanGenerator;

public class Lines {
    private final List<Line> lines = new ArrayList<>();

    public Lines(int count, int height, BooleanGenerator booleanGenerator) {
        Height linesHeight = new Height(height);
        for (int i = 0; i < linesHeight.getHeight(); i++) {
            lines.add(new Line(count, booleanGenerator));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
