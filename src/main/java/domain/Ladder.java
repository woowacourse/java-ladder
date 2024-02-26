package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final Height height;
    private final List<Line> lines;

    private Ladder(Height height, List<Line> lines) {
        this.height = height;
        this.lines = lines;
    }

    public static Ladder createLadderWithLines(Height height, int width) {
        return new Ladder(height, makeLines(height.getHeight(), width));
    }

    private static List<Line> makeLines(int height, int width) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            Line line = new Line();
            line.makeLeg(width);
            lines.add(line);
        }
        return lines;
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}
