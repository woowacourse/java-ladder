package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    private Ladder(final List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder create(Height height, PlayerCount playerCount) {
        return new Ladder(makeLadder(height, playerCount));
    }

    private static List<Line> makeLadder(Height height, PlayerCount playerCount) {
        List<Line> lines = new ArrayList<>();
        int count = height.getHeight();
        for (int index = 0; index < count; index++){
            lines.add(Line.create(playerCount, new RandomStepGenerator()));
        }
        return lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
