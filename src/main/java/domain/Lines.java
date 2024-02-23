package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import strategy.PointStrategy;

public class Lines {

    private final List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(int playerCount, Height height, PointStrategy pointStrategy) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            lines.add(Line.of(pointStrategy, playerCount));
        }
        return new Lines(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
