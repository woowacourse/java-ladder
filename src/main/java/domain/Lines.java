package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import strategy.ConnectionStrategy;

public class Lines {

    private final List<Line> lines = new ArrayList<>();

    public Lines(int memberCount, int height, ConnectionStrategy connectionStrategy) {
        generate(memberCount, height, connectionStrategy);
    }

    private void generate(int memberCount, int height, ConnectionStrategy connectionStrategy) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(memberCount, connectionStrategy));
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
