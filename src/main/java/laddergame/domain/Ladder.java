package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import laddergame.exception.LadderLineOverlappedException;

public class Ladder {

    private final List<Line> lines;

    private Ladder(final LadderHeight height, final BooleanGenerator booleanGenerator) {
        List<Line> lines = new ArrayList<>();

        while (height.isNot(lines.size())) {
            lines.add(createLine(booleanGenerator));
        }

        this.lines = lines;
    }

    public static Ladder create(final LadderHeight height, final BooleanGenerator booleanGenerator) {
        return new Ladder(height, booleanGenerator);
    }

    private Line createLine(final BooleanGenerator booleanGenerator) {
        try {
            return Line.create(booleanGenerator);
        } catch (LadderLineOverlappedException exception) {
            return createLine(booleanGenerator);
        }
    }

    public List<List<Boolean>> getLines() {
        return lines.stream()
                .map(Line::getPoints)
                .toList();
    }

    public int getHeight() {
        return lines.size();
    }
}
