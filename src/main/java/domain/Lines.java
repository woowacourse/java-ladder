package domain;

import java.util.ArrayList;
import java.util.List;
import utils.booleanGenerator.RandomBooleanGenerator;

public class Lines {
    private final List<Line> lines = new ArrayList<>();

    public Lines(int personNumber, int linesHeight) {
        Height height = new Height(linesHeight);
        RandomBooleanGenerator randomBooleanGenerator = new RandomBooleanGenerator();
        for (int i = 0; i < height.getHeight(); i++) {
            Line line = new Line(personNumber, randomBooleanGenerator);
            lines.add(line);
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
