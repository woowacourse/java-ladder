package domain;

import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        validateConnectedLadder(lines);
        this.lines = lines;
    }

    private void validateConnectedLadder(List<Line> lines) {
        int lastIndex = lines.get(0).length() - 1;
        boolean isConnectedLadder = IntStream.range(0, lastIndex)
                .allMatch(index -> isConnectedAtIndex(lines, index));
        if (!isConnectedLadder) {
            throw new IllegalStateException("두 지점 사이에는 반드시 한개 이상의 발판이 있어야 합니다.");
        }
    }

    private boolean isConnectedAtIndex(List<Line> lines, int index) {
        return lines.stream()
                .anyMatch(line -> line.isConnectWithNextPoint(index));
    }
}
