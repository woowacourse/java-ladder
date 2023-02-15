package domain;

import java.util.ArrayList;
import java.util.List;
import utils.booleanGenerator.RandomBooleanGenerator;

public class Lines {
    private final List<Line> lines = new ArrayList<>();

    public Lines(int personNumber, int linesHeight) {
        Height height = new Height(linesHeight);
        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(new Line(personNumber, new RandomBooleanGenerator()));
        }
    }

    public List<Line> getLines() {
        return lines;
    }

}
