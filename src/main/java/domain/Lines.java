package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import strategy.PointStrategy;

public class Lines {

    private final List<Line> lines = new ArrayList<>();

    public Lines(int playerCount, Height height, PointStrategy pointStrategy) {
        generate(playerCount, height, pointStrategy);
    }

    private void generate(int playerCount, Height height, PointStrategy pointStrategy) {
        for (int i = 0; i < height.getValue(); i++) {
            lines.add(new Line(playerCount, pointStrategy));
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
