package domain;

import java.util.ArrayList;
import java.util.List;
import util.LineGenerator;
import util.RandomLineGenerator;

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
        LineGenerator randomLineGenerator = new RandomLineGenerator();

        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(new Line(this.numberOfWalls - 1, randomLineGenerator));
        }
    }

    public List<Line> getLines() {
        return this.lines;
    }
}
