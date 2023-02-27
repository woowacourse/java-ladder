package domain.ladder;

import domain.player.Position;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public Position play(Position position) {
        for (Line line : lines) {
            move(position, line);
        }
        return position;
    }

    private void move(Position position, Line line) {
        if (line.isLeftSidePassable(position)) {
            position.moveLeft();
            return;
        }

        if (line.isRightSidePassable(position)) {
            position.moveRight();
        }
    }
}
