package domain;

import util.generator.LineGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    private Ladder(int height, int width, LineGenerator lineGenerator) {
        lines = makeLines(new Height(height), new Width(width), lineGenerator);
    }

    public static Ladder from(int height, int width, LineGenerator lineGenerator) {
        return new Ladder(height, width, lineGenerator);
    }

    private List<Line> makeLines(Height height, Width width, LineGenerator lineGenerator) {
        List<Line> newlines = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            newlines.add(Line.of(width.getWidth(), lineGenerator));
        }
        return newlines;
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}
