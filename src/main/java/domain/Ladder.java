package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import strategy.ConnectionStrategy;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int memberCount, int height, ConnectionStrategy connectionStrategy) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.from(memberCount, connectionStrategy));
        }
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
