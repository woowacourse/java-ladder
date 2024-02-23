package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(final List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder create(Height height, PlayerCount playerCount) {
        return new Ladder(createLines(height, playerCount));
    }

    private static List<Line> createLines(Height height, PlayerCount playerCount) {
        List<Line> lines = new ArrayList<>();
        StepGenerator randomStepGenerator = new RandomStepGenerator();

        for (int buildHeight = 0; height.isBiggerThan(buildHeight); buildHeight++) {
            lines.add(Line.create(playerCount, randomStepGenerator));
        }
        return lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
