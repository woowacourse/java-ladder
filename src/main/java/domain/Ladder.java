package domain;

import java.util.ArrayList;
import java.util.List;
import util.LineGenerator;

public class Ladder {

    private List<Line> lines;
    private final int numberOfWalls;
    private final Height height;

    public Ladder(int numberOfWalls, Height height, LineGenerator lineGenerator) {
        this.numberOfWalls = numberOfWalls;
        this.height = height;
        makeLines(lineGenerator);
    }

    public void makeLines(LineGenerator lineGenerator) {
        this.lines = new ArrayList<>();

        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(new Line(this.numberOfWalls - 1, lineGenerator));
        }
    }

    public List<Line> getLines() {
        return this.lines;
    }
}
