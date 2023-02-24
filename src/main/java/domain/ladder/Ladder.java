package domain.ladder;

import domain.generator.BooleanGenerator;
import domain.player.Position;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> ladder;

    public Ladder(int count, int height, BooleanGenerator ladderGenerator) {
        this.ladder = createLadder(count, height, ladderGenerator);
    }

    private static List<Line> createLadder(int count, int height, BooleanGenerator ladderGenerator) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(count, ladderGenerator));
        }
        return lines;
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }

    public Position findFinalPosition(Position initialPosition) {
        Position position = initialPosition;
        for (Line line : ladder) {
            position = position.findNextPosition(position, line);
        }
        return position;
    }
}
