package laddergame.domain;

import java.util.Collections;
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

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
