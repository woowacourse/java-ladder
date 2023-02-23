package domain;

import java.util.ArrayList;
import java.util.List;
import utils.BooleanGenerator;

public class Lines {
    private final List<Line> lines = new ArrayList<>();

    public Lines(int personNumber, int height, BooleanGenerator booleanGenerator) {
        for (int i = 0; i < height; i++) {
            Line line = new Line(personNumber, booleanGenerator);
            lines.add(line);
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
