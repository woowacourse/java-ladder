package domain;

import util.generator.RandomBooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final Height height;
    private final Width width;
    private final List<Line> lines;

    private Ladder(int height, int width) {
        this.height = new Height(height);
        this.width = new Width(width);
        this.lines = new ArrayList<>();
    }

    public static Ladder from(int height, int width) {
        Ladder ladder = new Ladder(height, width);
        ladder.makeLines(width);
        return ladder;
    }

    private void makeLines(int width) {
        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(Line.of(width, new RandomBooleanGenerator()));
        }
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}
