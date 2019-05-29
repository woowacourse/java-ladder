package laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(final LadderHeight ladderHeight, final int width) {
        lines = new ArrayList<>();

        final int height = ladderHeight.getLadderHeight();
        for (int i = 0; i <= height; i++) {
            lines.add(new Line(width));
        }
    }

    public boolean connectBridge(final Position input) {
        try {
            return lines.get(input.getRow()).connect(input.getColumn());
        } catch (IndexOutOfBoundsException e) {
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public int findDestination(int startPosition) {
        for (Line line : lines) {
            startPosition += line.findPosition(startPosition).move();
        }
        return startPosition;
    }

    public List<Line> getLadderFormat() {
        return new ArrayList<>(lines.subList(1, lines.size()));
    }

    public int getHeight() {
        return (lines.size() - 1);
    }

    public int getWidth() {
        return lines.get(1).getWidth();
    }
}
