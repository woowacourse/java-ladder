package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    private Ladder(final List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder create(final int lineSize, final LadderHeight height,
            final BooleanGenerator booleanGenerator) {

        final List<Line> lines = new ArrayList<>();

        while (isNotCompleted(lines, height)) {
            lines.add(Line.create(lineSize, booleanGenerator));
        }

        return new Ladder(lines);
    }

    private static boolean isNotCompleted(final List<Line> lines, final LadderHeight height) {
        // TODO : isNot 메소드 명 변경
        return height.isNot(lines.size());
    }

    public List<List<Boolean>> getLines() {
        return lines.stream()
                .map(Line::getPoints)
                .toList();
    }
}
