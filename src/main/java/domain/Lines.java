package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import strategy.ConnectionStrategy;

public class Lines {

    private final List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines from(int memberCount, int height, ConnectionStrategy connectionStrategy) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(memberCount, connectionStrategy));
        }
        return new Lines(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
