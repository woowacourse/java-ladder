package laddergame.fixture;

import laddergame.domain.Line;
import laddergame.domain.Lines;

import java.util.ArrayList;
import java.util.List;

public abstract class LinesFixture {
    public static Lines createLines(final int width, final int height) {
        final List<Line> values = new ArrayList<>();
        for (int count = 0; count < height; count++) {
            values.add(LineFixture.createLine(width));
        }
        return new Lines(values);
    }
}
