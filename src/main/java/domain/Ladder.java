package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(final Height height, final PlayerCount playerCount) {
        this.lines = makeLadder(height, playerCount);
    }

    private List<Line> makeLadder(Height height, PlayerCount playerCount) {
        List<Line> lines = new ArrayList<>();
        int count = height.getHeight();
        for (int index = 0; index < count; index++){
            lines.add(new Line(playerCount));
        }
        return lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int climbLadder(int position) {
        for (Line line : lines) {
            position = line.climb(position);
        }
        return position;
    }
}
