package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.linegenerator.LineGenerator;

public class Ladder {
    private final List<Line> lines;

    public Ladder(Height height, int size, LineGenerator lineGenerator) {
        lines = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            Line line = new Line(lineGenerator.generate(size));
            lines.add(line);
        }
    }

    public int getHeight() {
        return lines.size();
    }
}
