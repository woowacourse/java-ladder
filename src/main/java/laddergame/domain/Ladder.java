package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import laddergame.utils.LineMaker;

public class Ladder {

    private final List<Line> lines;
    private final Height height;
    private final int userCount;
    private final LineMaker lineMaker;

    public Ladder(Height height, int userCount, LineMaker lineMaker) {
        this.lines = new ArrayList<>();
        this.height = height;
        this.userCount = userCount;
        this.lineMaker = lineMaker;
        addLine();
    }

    private void addLine() {
        for (int line = 0; line < height.getHeight(); line++) {
            lines.add(new Line(lineMaker, userCount));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
