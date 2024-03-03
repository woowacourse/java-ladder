package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LadderRow {

    private final List<Line> isLines;

    public LadderRow(BooleanGenerator generator, int size) {
        List<Boolean> row = new ArrayList<>(); //TODO 더 좋은 방법
        row.add(generator.generate());
        IntStream.range(1, size).forEach(index -> row.add(generateNext(row.get(index - 1), generator)));
        this.isLines = row.stream().map(Line::valueOf).toList();
    }

    LadderRow(List<Boolean> row) {
        validateLadderRow(row); // TODO 위의 LadderRow와 중복 문제 해결
        this.isLines = row.stream().map(Line::valueOf).toList();
    }

    private void validateLadderRow(List<Boolean> isLines) {//TODO reduce(), atomicInteger
        IntStream.range(1, isLines.size()).forEach(index -> isConsecutiveTrue(isLines, index));
    }

    private boolean generateNext(boolean isTrue, BooleanGenerator generator) {
        if (isTrue) {
            return false;
        }
        return generator.generate();
    }

    private void isConsecutiveTrue(List<Boolean> isLines, int index) {
        if (isLines.get(index - 1) && isLines.get(index)) {
            throw new IllegalStateException("연속된 true 값이 존재하면 안됩니다");
        }
    }

    public Position moveLinkedPosition(Position position) {
        if (isLeftConnected(position)) {
            return position.decrement();
        }
        if (isRightConnected(position)) {
            return position.increment();
        }
        return position;
    }

    private boolean isRightConnected(Position position) {
        return position.value() < isLines.size() && isLines.get(position.value()).isConnected();
    }

    private boolean isLeftConnected(Position position) {
        return position.value() > 0 && isLines.get(position.value() - 1).isConnected();
    }

    public List<Line> getIsLines() {
        return isLines;
    }

    public int size() {
        return isLines.size();
    }
}
