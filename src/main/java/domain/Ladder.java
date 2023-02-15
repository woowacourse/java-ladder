package domain;

import java.util.ArrayList;
import java.util.List;
import utils.RandomLineMaker;

public class Ladder {

    private final List<Line> lines;
    private final Height height;
    private final int userCount;

    public Ladder(int height, int userCount) {
        this.lines = new ArrayList<>();
        this.height = new Height(height);
        this.userCount = userCount;
        addLine();
    }

    private void addLine() {
        RandomLineMaker randomLineMaker = new RandomLineMaker();
        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(new Line(randomLineMaker, userCount));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
