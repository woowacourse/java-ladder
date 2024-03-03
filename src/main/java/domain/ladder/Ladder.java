package domain.ladder;

import domain.ladder.stick.Stick;
import domain.ladder.sticks.SticksGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final Height height;
    private final List<Line> lines;

    private Ladder(Height height, List<Line> lines) {
        this.height = height;
        this.lines = lines;
    }

    public static Ladder of(Height height, int playerSize, SticksGenerator sticksGenerator) {
        int stickCount = playerSize - 1;
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height.getHeight(); i++) {
            List<Stick> sticks = sticksGenerator.generate(stickCount);
            lines.add(new Line(sticks));
        }

        return new Ladder(height, lines);
    }

    public List<Line> getLines() {
        return this.lines;
    }

    public int getHeight() {
        return this.height.getHeight();
    }

    public int climb(int startPosition) {
        int currentPosition = startPosition;
        for (Line line : this.lines) {
            currentPosition = line.climb(currentPosition);
        }

        return currentPosition;
    }
}
