package laddergame.domain.ladder;

import laddergame.domain.rung.Line;
import laddergame.util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class LinesMaker {

    private final BooleanGenerator rungBooleanGenerator;

    private LinesMaker(final BooleanGenerator rungBooleanGenerator) {
        this.rungBooleanGenerator = rungBooleanGenerator;
    }

    static LinesMaker create(final BooleanGenerator rungBooleanGenerator) {
        return new LinesMaker(rungBooleanGenerator);
    }

    public List<Line> makeLines(final int heightNumber, final int rungCount) {
        List<Line> lines = new ArrayList<>();
        for (int index = 0; index < heightNumber; index++) {
            lines.add(Line.create(rungCount, rungBooleanGenerator));
        }
        return lines;
    }
}
