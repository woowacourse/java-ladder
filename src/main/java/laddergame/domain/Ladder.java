package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import laddergame.exception.LadderLineOverlappedException;

public class Ladder {

    private final List<Line> lines;

    private Ladder(final int height, final int personSize, final BooleanGenerator booleanGenerator) {
        List<Line> lines = new ArrayList<>();

        while (lines.size() != height) {
            lines.add(createLine(personSize, booleanGenerator));
        }

        this.lines = lines;
    }

    public static Ladder create(final int height, final int personSize, final BooleanGenerator booleanGenerator) {
        return new Ladder(height, personSize, booleanGenerator);
    }

    public List<List<Boolean>> getLines() {
        return lines.stream().map(Line::getPoints).collect(Collectors.toList());
    }

    private Line createLine(final int personSize, final BooleanGenerator booleanGenerator) {
        try {
            return Line.create(personSize, booleanGenerator);
        } catch (LadderLineOverlappedException exception) {
            return createLine(personSize, booleanGenerator);
        }
    }

    public int getHeight() {
        return lines.size();
    }

    public int getWidth(final Names names) {
        final int maxLengthSkipFirst = names.getMaxLengthSkipFirst();
        final int lastLength = names.getLastLength();

        if (maxLengthSkipFirst == lastLength) {
            return lastLength + 1;
        }

        return maxLengthSkipFirst;
    }
}
