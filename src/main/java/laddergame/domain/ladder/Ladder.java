package laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.List;

import java.util.Random;

public class Ladder {
    private final int height;            // 행
    private final int width;            // 렬
    private List<Line> ladder;

    public Ladder(int height, int width) {
        this.height = height;
        this.width = width;
        ladder = new ArrayList<>();

        for (int i = 0; i <= height; i++) {
            ladder.add(new Line(width));
        }
    }

    public void connectBridgesRandomly(int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int randomRow = random.nextInt(height - 1) + 1;              // 1 ~ height
            int randomColumn = random.nextInt((width - 1)) + 1;                 // 1 ~ width

            connectBridge(randomRow, randomColumn);
        }
    }

    public void connectBridge(int row, int column) {
        try {
            ladder.get(row).connect(column);
        } catch (IndexOutOfBoundsException e) {
            // 인덱스 범위 벗어날 시 아무 수행하지 않는다.
        }
    }

    public int findIndexOfResult(int startPosition) {
        for (Line line : ladder) {
            startPosition += line.findRoute(startPosition);
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
