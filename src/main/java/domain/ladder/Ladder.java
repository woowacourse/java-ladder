package domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    public static final int LINE_MIN_SIZE = 1;
    public static final int LINE_MAX_SIZE = 30;

    private final List<Line> lines;

    private Ladder(final List<Line> lines) {
        validate(lines);
        this.lines = new ArrayList<>(lines);
    }

    public static Ladder of(final int playersSize, final int ladderHeight, final PointGenerator pointGenerator) {
        List<Line> lines = new ArrayList<>();
        for (int lineIndex = 0; lineIndex < ladderHeight; lineIndex++) {
            int pointNum = playersSize - 1;
            lines.add(Line.of(pointNum, pointGenerator));
        }
        return new Ladder(lines);
    }

    private void validate(final List<Line> lines) {
        if (lines.size() < LINE_MIN_SIZE || lines.size() > LINE_MAX_SIZE) {
            throw new IllegalArgumentException("사다리의 높이는 1이상 30이하여야 합니다.");
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

}
