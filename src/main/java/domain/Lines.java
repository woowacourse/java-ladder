package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import strategy.PointStrategy;

public class Lines {

    private final List<Line> lines = new ArrayList<>();

    public Lines(int memberCount, int height, PointStrategy pointStrategy) {
        generate(memberCount, height, pointStrategy);
    }

    private void generate(int memberCount, int height, PointStrategy pointStrategy) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(memberCount, pointStrategy));
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
