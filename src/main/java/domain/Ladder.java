package domain;

import java.util.ArrayList;
import java.util.List;
import utils.NumberGenerator;

public class Ladder {

    private final List<Line> lines;
    private final LadderHeight ladderHeight;

    private Ladder(List<Line> lines, LadderHeight ladderHeight) {
        this.lines = lines;
        this.ladderHeight = ladderHeight;
    }

    public static Ladder create(int numberOfPeople,
                                LadderHeight ladderHeight,
                                NumberGenerator numberGenerator) {
        List<Line> lines = new ArrayList<>();
        Ladder ladder = new Ladder(lines, ladderHeight);
        ladder.addLines(numberOfPeople, numberGenerator);
        return ladder;
    }

    private void addLines(int numberOfPeople, NumberGenerator numberGenerator) {
        for (int i = 0; i < height(); i++) {
            lines.add(Line.create(numberOfPeople, numberGenerator));
        }
    }

    public Position getResultPositionOf(Position position) {
        int horizontalPosition = position.value();
        for (Line line : lines) {
            horizontalPosition = getNextHorizontalPosition(line, horizontalPosition);
        }
        return new Position(horizontalPosition);
    }

    private int getNextHorizontalPosition(Line line, int horizontalPosition) {
        if (haveRightPoint(line, horizontalPosition)) {
            return horizontalPosition + 1;
        }
        if (haveLeftPoint(line, horizontalPosition)) {
            return horizontalPosition - 1;
        }
        return horizontalPosition;
    }

    private boolean haveRightPoint(Line line, int horizontalPosition) {
        if (horizontalPosition == line.width()) {
            return false;
        }
        return line.points().get(horizontalPosition).isPassable();
    }

    private boolean haveLeftPoint(Line line, int horizontalPosition) {
        if (horizontalPosition == 0) {
            return false;
        }
        return line.points().get(horizontalPosition - 1).isPassable();
    }

    public List<Line> lines() {
        return List.copyOf(lines);
    }

    public int height() {
        return ladderHeight.value();
    }
}
