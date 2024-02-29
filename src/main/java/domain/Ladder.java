package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    private Ladder(final List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder create(Height height, PlayerCount playerCount, StepGenerator stepGenerator) {
        return new Ladder(createLines(height, playerCount, stepGenerator));
    }

    private static List<Line> createLines(Height height, PlayerCount playerCount, StepGenerator stepGenerator) {
        List<Line> lines = new ArrayList<>();

        for (int buildHeight = 0; height.isBiggerThan(buildHeight); buildHeight++) {
            lines.add(Line.create(playerCount, stepGenerator));
        }
        return lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
