package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder createByStrategy(PointGenerator pointGenerator, int height, int personCount) {
        final List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.createByStrategy(pointGenerator, personCount));
        }
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
