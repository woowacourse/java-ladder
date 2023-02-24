package domain.ladder;

import domain.generator.BooleanGenerator;
import domain.player.Position;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public Ladder(int count, int height, BooleanGenerator ladderGenerator) {
        Height linesHeight = new Height(height);
        for (int i = 0; i < linesHeight.getHeight(); i++) {
            lines.add(new Line(count, ladderGenerator));
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public Position findFinalPosition(Position initialPosition) {
        Position position = initialPosition;
        for (Line line : lines) {
            position = position.findNextPosition(position, line);
        }
        return position;
    }
}
