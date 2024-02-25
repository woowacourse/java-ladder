package ladder.model;

import ladder.constant.LadderPath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static ladder.constant.LadderPath.*;

public class Line {
    private final List<LadderPath> row;

    public Line(List<LadderPath> row) {
        validate(row);
        this.row = row;
    }

    private void validate(List<LadderPath> row) {
        if (isLeftOnFirst(row) || isNotExistRightBeforeLeft(row)) {
            throw new IllegalArgumentException("왼쪽 경로 왼쪽에 오른쪽 경로가 없습니다.");
        }
        if (isRightOnEnd(row) || isNotExistLeftAfterRight(row)) {
            throw new IllegalArgumentException("오른쪽 경로 오른쪽에 왼쪽 경로가 없습니다.");
        }
    }

    private boolean isLeftOnFirst(List<LadderPath> row) {
        return row.get(0) == LEFT;
    }

    private boolean isRightOnEnd(List<LadderPath> row) {
        return row.get(row.size() - 1) == RIGHT;
    }

    private boolean isNotExistRightBeforeLeft(List<LadderPath> row) {
        return IntStream.range(0, row.size())
                .filter(i -> row.get(i).isLeftPath())
                .map(idx -> idx - 1)
                .anyMatch(idx -> row.get(idx).isNotRightPath());
    }

    private boolean isNotExistLeftAfterRight(List<LadderPath> row) {
        return IntStream.range(0, row.size())
                .filter(i -> row.get(i).isRightPath())
                .map(idx -> idx + 1)
                .anyMatch(idx -> row.get(idx).isNotLeftPath());
    }

    public List<Integer> findBars() {
        List<Integer> bars = new ArrayList<>();

        IntStream.range(0, row.size())
                .filter(idx -> row.get(idx).equals(RIGHT))
                .forEach(bars::add);

        return bars;
    }

    public int size() {
        return row.size();
    }

    public List<LadderPath> getRow() {
        return Collections.unmodifiableList(row);
    }
}
