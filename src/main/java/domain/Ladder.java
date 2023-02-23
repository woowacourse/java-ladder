package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private static final int FIRST_FLOOR = 0;

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder generateLadder(int ladderHeight, Players players, BooleanGenerator booleanGenerator) {
        List<Line> ladderLine = new ArrayList<>();

        for (int i = FIRST_FLOOR; i < ladderHeight; i++) {
            Line line = Line.generateLine(booleanGenerator, players);
            ladderLine.add(line);
        }

        return new Ladder(ladderLine);
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }

    public int getHeight() {
        return lines.size();
    }
}
