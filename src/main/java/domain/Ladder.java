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

    public static Ladder createLadderWithLines(LegGenerateStrategy legGenerateStrategy, Height height, int width) {
        return new Ladder(height, makeLines(legGenerateStrategy, height.getHeight(), width));
    }

    private static List<Line> makeLines(LegGenerateStrategy legGenerateStrategy, int height, int width) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            Line line = Line.createLineWithLegs(legGenerateStrategy, width);
            lines.add(line);
        }
        return lines;
    }

    public int getResultIndex(int startTopIndex) {
        int presentIndex = startTopIndex;
        for (int i = 0; i < height.getHeight(); i++) {
            Line presentLine = lines.get(i);
            presentIndex = presentLine.moveToNextIndex(presentIndex);
        }
        return presentIndex;
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}
