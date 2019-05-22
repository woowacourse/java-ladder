package laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.List;

import java.util.Random;

public class Ladder {

    private final List<Line> ladder;

    public Ladder(final int height, final int width) {
        ladder = new ArrayList<>();

        for (int i = 0; i <= height; i++) {
            ladder.add(new Line(width));
        }
    }

    public void connectBridgesRandomly(final int count) {
        final int height = ladder.size() - 1;
        final int width = ladder.get(1).getWidth();
        for (int i = 0; i < count; i++) {
            final int randomRow = new Random().nextInt(height) + 1;
            final int randomCol = (int) (Math.random() * width) + 1;

            connectBridge(Position.of(randomRow, randomCol));
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Line line : ladder.subList(1, ladder.size())) {
            stringBuilder.append(line);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
