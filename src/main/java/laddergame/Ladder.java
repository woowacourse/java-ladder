package laddergame;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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

    public int getWidth(Names names) {
        final List<Integer> nameSizes = names.getNameSizes();

        return nameSizes.stream().skip(1).max(Comparator.naturalOrder()).orElse(0);
    }
}
