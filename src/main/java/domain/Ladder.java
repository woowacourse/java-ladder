package domain;

import java.util.ArrayList;
import java.util.List;
import utils.RandomLineMaker;

public class Ladder {

    private final List<Line> lines;
    private final Height height;
    private final int userCount;

    public Ladder(Height height, int userCount) {
        this.lines = new ArrayList<>();
        this.height = height;
        this.userCount = userCount;
        addLine();
    }

    private void addLine() {
        RandomLineMaker randomLineMaker = new RandomLineMaker();
        for (int line = 0; line < height.getHeight(); line++) {
            lines.add(new Line(randomLineMaker, userCount));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
