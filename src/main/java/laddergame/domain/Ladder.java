package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import laddergame.exception.InvalidLadderException;

public class Ladder {

    private final List<Line> lines;

    public Ladder(final List<Line> lines) {
        validateEmpty(lines);
        validateSameSize(lines);
        this.lines = lines;
    }

    private void validateEmpty(final List<Line> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 라인없이 사다리를 생성할 수 없습니다.");
        }
    }

    private void validateSameSize(final List<Line> lines) {
        if (getUniqueSize(lines) != 1) {
            throw new InvalidLadderException("[ERROR] 라인 길이가 다른 사다리를 생성할 수 없습니다.");
        }
    }

    private int getUniqueSize(final List<Line> lines) {
        return lines.stream()
                .map(Line::size)
                .distinct()
                .toList()
                .size();
    }

    public static Ladder create(final LineSize lineSize, final LadderHeight height,
            final PointGenerator pointGenerator) {
        final List<Line> lines = new ArrayList<>();

        while (height.isBiggerThan(lines.size())) {
            lines.add(Line.create(lineSize, pointGenerator));
        }

        return new Ladder(lines);
    }

    public List<List<Boolean>> getLinesState() {
        return lines.stream()
                .map(Line::getPointsState)
                .toList();
    }
}
