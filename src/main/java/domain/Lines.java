package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import strategy.PointStrategy;

public class Lines {

    private final List<Line> lines = new ArrayList<>();
    private final PointStrategy pointStrategy;

    public Lines(int playerCount, Height height, PointStrategy pointStrategy) {
        this.pointStrategy = pointStrategy;
        generate(playerCount, height);
    }

    private void generate(int playerCount, Height height) {
        for (int i = 0; i < height.getValue(); i++) {
            lines.add(new Line(playerCount, pointStrategy));
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
