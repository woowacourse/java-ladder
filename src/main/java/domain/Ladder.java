package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> lines;
    private final int numberOfWalls;
    private final Height height;

    public Ladder(int numberOfWalls, Height height) {
        this.numberOfWalls = numberOfWalls;
        this.height = height;
        makeLines();
    }

    public void makeLines() {
        this.lines = new ArrayList<>();

        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(new Line(this.numberOfWalls - 1, new RandomLineGenerator()));
        }
    }

    public List<String> getLadderLines() {
        List<String> ladderLines = new ArrayList<>();
        for (Line line : lines) {
            ladderLines.add(line.getLineStatus());
        }

        return ladderLines;
    }

    public List<Line> getLines() {
        return lines;
    }
}
