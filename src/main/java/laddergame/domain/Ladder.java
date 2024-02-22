package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    private Ladder(final List<Line> lines) {
        this.lines = lines;
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
