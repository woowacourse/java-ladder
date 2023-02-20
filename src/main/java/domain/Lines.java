package domain;

import java.util.ArrayList;
import java.util.List;
import util.LineGenerator;

public class Lines {

    private List<Line> lines;

    public Lines(int numberOfWalls, Height height, LineGenerator lineGenerator) {
        makeLines(numberOfWalls, height, lineGenerator);
    }

    public void makeLines(int numberOfWalls, Height height, LineGenerator lineGenerator) {
        this.lines = new ArrayList<>();

        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(new Line(numberOfWalls - 1, lineGenerator));
        }
    }

    public List<Line> getLines() {
        return this.lines;
    }
}
