package domain;

import util.generator.RandomBooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    private Ladder(int height, int width) {
        lines = makeLines(new Height(height), new Width(width));
    }

    public static Ladder from(int height, int width) {
        return new Ladder(height, width);
    }

    private List<Line> makeLines(Height height, Width width) {
        List<Line> newlines = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            newlines.add(Line.of(width.getWidth(), new RandomBooleanGenerator()));
        }
        return newlines;
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}
