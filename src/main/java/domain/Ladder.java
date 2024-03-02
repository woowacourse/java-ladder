package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final Height height;
    private final List<Line> lines;

    public Ladder(LegGenerateStrategy legGenerateStrategy, Height height, int width) {
        this.height = height;
        this.lines = makeLines(legGenerateStrategy, height.getHeight(), width);
    }

    private static List<Line> makeLines(LegGenerateStrategy legGenerateStrategy, int height, int width) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            Line line = new Line(legGenerateStrategy, width);
            lines.add(line);
        }
        return lines;
    }

    public int getResultIndex(int startTopIndex) {
        int presentIndex = startTopIndex;
        for (int i = 0; i < height.getHeight(); i++) {
            Line presentLine = lines.get(i);
            presentIndex = presentLine.moveToNextLeg(presentIndex);
        }
        return presentIndex;
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}
