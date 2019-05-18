package laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.List;

import java.util.Random;

public class Ladder {

    private List<Line> ladder;

    public Ladder(int height, int width) {
        ladder = new ArrayList<>();

        for (int i = 0; i <= height; i++) {
            ladder.add(new Line(width));
        }
    }

    public void connectBridgesRandomly(int count) {
        int height = ladder.size() - 1;
        int width = ladder.get(0).getWidth();
        for (int i = 0; i < count; i++) {
            int randomRow = new Random().nextInt(height) + 1;
            int randomCol = (int) (Math.random() * width) + 1;

            connectBridge(randomRow, randomCol);
        }
    }

    public void connectBridge(int row, int column) {
        try {
            ladder.get(row).connect(column);
        } catch (IndexOutOfBoundsException e) {
        } catch (IllegalArgumentException e) {
            // 왼쪽이나 오른쪽에 연결로가 중복될 떄
        }
    }

    public int findDestination(int startPosition) {
        for (Line line : ladder) {
            startPosition += line.findRoute(startPosition).move();
        }
        return startPosition;
    }

    public boolean isLinked(int row, int column) {
        try {
            return ladder.get(row).isLinked(column);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
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
