package laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> ladder;

    public Ladder(final LadderHeight ladderHeight, final int width) {
        ladder = new ArrayList<>();

        final int height = ladderHeight.getLadderHeight();
        for (int i = 0; i <= height; i++) {
            ladder.add(new Line(width));
        }
    }

    public boolean connectBridge(final Position input) {
        try {
            return ladder.get(input.getRow()).connect(input.getColumn());
        } catch (IndexOutOfBoundsException e) {
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public int findDestination(int startPosition) {
        for (Line line : ladder) {
            startPosition += line.findPosition(startPosition).move();
        }
        return startPosition;
    }

    public List<Line> getLadderFormat() {
        return new ArrayList<>(ladder.subList(1, ladder.size()));
    }

    public int getHeight() {
        return (ladder.size() - 1);
    }

    public int getWidth() {
        return ladder.get(1).getWidth();
    }
}
