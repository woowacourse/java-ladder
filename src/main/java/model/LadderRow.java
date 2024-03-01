package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LadderRow {

    private final List<Line> isLines;

    public LadderRow(LadderRowGenerator generator, int size) {
        List<Boolean> row = new ArrayList<>(); //TODO 더 좋은 방법
        row.add(generator.generate(false));
        IntStream.range(1, size).forEach(index -> row.add(generator.generate(row.get(index))));
        validateLadderRow(row);
        this.isLines = row.stream().map(Line::valueOf).toList();
    }

    LadderRow(List<Boolean> row) {
        validateLadderRow(row); // TODO 위의 LadderRow와 중복 문제 해결
        this.isLines = row.stream().map(Line::valueOf).toList();
    }

    private void validateLadderRow(List<Boolean> isLines) {//TODO reduce(), atomicInteger
        for (int i = 1; i < isLines.size(); i++) {
            isConsecutiveTrue(isLines, i);
        }
    }

    private void isConsecutiveTrue(List<Boolean> isLines, int index) {
        if (isLines.get(index - 1) && isLines.get(index)) {
            throw new IllegalStateException("연속된 true 값이 존재하면 안됩니다");
        }
    }

    public Position move(Position position) {
        if (position.value() > 0 && isLines.get(position.value() - 1).isConnected()) {
            return position.decrement();
        }
        if (position.value() < isLines.size() && isLines.get(position.value()).isConnected()) {
            return position.increment();
        }
        return position;
    }

    public List<Line> getIsLines() {
        return isLines;
    }

    public int size() {
        return isLines.size();
    }
}
