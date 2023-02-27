package domain.ladder;

import domain.generator.LadderStepGenerator;
import domain.player.Position;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int count, Height height, LadderStepGenerator ladderGenerator) {
        this.lines = createLadder(count, height, ladderGenerator);
    }

    private static List<Line> createLadder(int count, Height height, LadderStepGenerator ladderGenerator) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            lines.add(new Line(count, ladderGenerator));
        }
        return lines;
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
