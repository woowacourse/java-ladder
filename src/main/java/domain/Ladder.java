package domain;

import java.util.List;
import java.util.stream.IntStream;
import util.RetryHelper;

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

    public int climb(int startIndex) {
        int endIndex = startIndex;
        for (Line line : lines) {
            endIndex = line.move(endIndex);
        }
        return endIndex;
    }

    List<List<Boolean>> getRawLadder() {
        return lines.stream()
                .map(Line::getRawLine)
                .toList();
    }

    public static Ladder of(LineGenerateStrategy lineGenerateStrategy, int ladderHeight, int lineSize) {
        RetryHelper retryHelper = new RetryHelper(Integer.MAX_VALUE);
        return retryHelper.retry(() -> {
            List<Line> lines = IntStream.range(0, ladderHeight)
                    .mapToObj(value -> Line.of(lineGenerateStrategy, lineSize))
                    .toList();
            return new Ladder(lines);
        });
    }
}
