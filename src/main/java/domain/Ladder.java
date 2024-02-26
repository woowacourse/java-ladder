package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(final List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder create(int height, PlayerCount playerCount, StepGenerator randomStepGenerator) {
        return new Ladder(createLines(height, playerCount, randomStepGenerator));
    }

    private static List<Line> createLines(int height, PlayerCount playerCount, StepGenerator randomStepGenerator) {
        List<Line> lines = new ArrayList<>();

        for (int buildHeight = 0; buildHeight < height; buildHeight++) {
            lines.add(Line.create(playerCount, randomStepGenerator));
        }
        return lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
