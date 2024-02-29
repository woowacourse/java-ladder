package domain.ladder;

import domain.ladder.stick.Stick;
import domain.ladder.sticks.SticksGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final Height height;
    private final List<Line> lines = new ArrayList<>();

    public Ladder(Height height, int playerSize, SticksGenerator sticksGenerator) {
        this.height = height;
        int stickCount = playerSize - 1;

        for (int i = 0; i < height.getHeight(); i++) {
            List<Stick> sticks = sticksGenerator.generate(stickCount);
            this.lines.add(new Line(sticks));
        }
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
