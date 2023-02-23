package laddergame.fixture;

import laddergame.domain.Line;

import java.util.ArrayList;
import java.util.List;

public abstract class LineFixture {
    public static Line createLine(final int size) {
        final List<Boolean> values = new ArrayList<>();
        for (int count = 0; count < size; count++) {
            values.add(count % 2 == 0);
        }
        return new Line(values);
    }
}
