package domain;

import util.generator.RandomBooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final Height height;
    private final List<Line> lines;

    public Ladder(int height) {
        this.height = new Height(height);
        this.lines = new ArrayList<>();
    }

    public void makeLines(int width) {
        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(Line.of(width, new RandomBooleanGenerator()));
        }
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}
