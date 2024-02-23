package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import strategy.PointStrategy;

public class Lines {

    private final List<Line> lines;

    public Lines(int playerCount, Height height, PointStrategy pointStrategy) {
        this.lines = generate(playerCount, height, pointStrategy);
    }

    private List<Line> generate(int playerCount, Height height, PointStrategy pointStrategy) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            lines.add(new Line(pointStrategy, playerCount));
        }
        return lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
