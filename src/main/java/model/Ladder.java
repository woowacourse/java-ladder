package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Ladder {

    private static final int MINIMUM_LINE_SIZE = 1;

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        validateLine(lines);

        this.lines = new ArrayList<>(lines);
    }

    private void validateLine(List<Line> lines) {
        if (Objects.isNull(lines)) {
            throw new IllegalStateException("사다리 줄이 정상적으로 입력되지 않았습니다.");
        }
        if (lines.size() < MINIMUM_LINE_SIZE) {
            throw new IllegalArgumentException("1 이상의 사다리 줄을 입력해주세요.");
        }
        if (isNoneEqualLineSize(lines)) {
            throw new IllegalArgumentException("각 사다리 줄에서 이동할 수 있는 경로의 수가 일치하지 않습니다.");
        }
    }

    private boolean isNoneEqualLineSize(List<Line> lines) {
        if (lines.size() <= MINIMUM_LINE_SIZE) {
            return false;
        }
        return IntStream.range(0, lines.size() - 1)
                .noneMatch(i -> isNoneEqualLineSize(lines.get(i), lines.get(i + 1)));
    }

    private boolean isNoneEqualLineSize(Line firstLine, Line secondLine) {
        return firstLine.isSamePathSize(secondLine);
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}
