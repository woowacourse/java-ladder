package domain;

import java.util.ArrayList;
import java.util.List;
import util.BooleanGenerator;

public class Ladder {
    private final List<Line> lines;

    private Ladder() {
        this.lines = new ArrayList<>();
    }

    public static Ladder generate(BooleanGenerator booleanGenerator, Height height, int personCount) {
        Ladder ladder = new Ladder();
        ladder.generate(booleanGenerator, height.getHeight(), personCount);
        return ladder;
    }

    private void generate(BooleanGenerator booleanGenerator, int height, int personCount) {
        for (int index = 0; index < height; index++) {
            lines.add(Line.generateWithBridges(booleanGenerator, personCount));
        }
    }

    public int findDestination(int currentPosition) {
        for (Line line : lines) {
            currentPosition = line.findPositionAbleToMove(currentPosition - 1, currentPosition, currentPosition);
        }
        return currentPosition;
    }

    public int calculateTotalHeight() {
        return lines.size();
    }

    public List<Line> getLines() {
        return lines;
    }
}
