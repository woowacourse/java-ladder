package domain;

import util.LineGenerator;

import java.util.ArrayList;
import java.util.List;

public class Lines {

    private final List<Line> lines;

    public Lines(int numberOfWalls, Height height, LineGenerator lineGenerator) {
        this.lines = new ArrayList<>();

        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(new Line(numberOfWalls - 1, lineGenerator));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
