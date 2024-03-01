package domain;

import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        int ladderWeight = lines.get(0).length();
        boolean[] isConnectedWithNext = new boolean[ladderWeight - 1];
        for (int index = 0; index < ladderWeight - 1; index++) {
            for (Line line : lines) {
                isConnectedWithNext[index] = line.isConnectWithNextPoint(index);
                if (isConnectedWithNext[index]) {
                    break;
                }
            }
        }
        for (int index = 0; index < ladderWeight - 1; index++) {
            if (!isConnectedWithNext[index]) {
                throw new IllegalStateException("두 지점 사이에는 반드시 한개 이상의 발판이 있어야 합니다.");
            }
        }
        this.lines = lines;
    }
}
