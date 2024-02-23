package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.linegenerator.LineGenerator;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder makeLadder(Height height, int width, LineGenerator lineGenerator) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            Line line = new Line(lineGenerator.generate(width));
            lines.add(line);
        }
        return new Ladder(lines);
    }

    public int getHeight() {
        return lines.size();
    }

    public int getWidth() {
        return lines.get(0).getWidth();
    }

    public boolean isExist(int height, int width) {
        return lines.get(height).isExist(width);
    }
}
