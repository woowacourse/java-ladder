package domain;

import util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Lines {

    private final List<Line> lines;

    public Lines(int numberOfWalls, Height height, BooleanGenerator booleanGenerator) {
        this.lines = new ArrayList<>();

        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(new Line(numberOfWalls - 1, booleanGenerator));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
