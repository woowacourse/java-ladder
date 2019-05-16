package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

import java.util.Random;

public class Ladder {
    // TODO 인스턴스 필드의 갯수를 줄이는 부분을 고민해볼 것
    private final int height;            // 행
    private final int width;            // 렬
    private List<Line> ladder;

    public Ladder(int height, int width) {
        this.height = height;
        this.width = width;
        ladder = new ArrayList<>();

        // TODO 인덱스 접근 범위 고민 : 0 || 1로 시작
        for (int i = 0; i <= height; i++) {
            ladder.add(new Line(width));
        }
    }

    public void connectBridgesRandomly(int count) {
        for (int i = 0; i < count; i++) {
            int randomRow = new Random().nextInt(height) + 1;
            int randomCol = (int) (Math.random() * (width - 1)) + 1;

            connectBridge(randomRow, randomCol);
        }
    }

    public void connectBridge(int row, int column) {
        try {
            ladder.get(row).connect(column);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("연결로를 추가할 수 없음 (테스트용)");
        } catch (IllegalArgumentException e) {
            // 왼쪽이나 오른쪽에 연결로가 중복될 떄
        }
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

    public int findResultIndex(int startPosition) {
        for (Line line : ladder) {
            startPosition += line.findRoute(startPosition);
        }
        return startPosition;
    }
}
